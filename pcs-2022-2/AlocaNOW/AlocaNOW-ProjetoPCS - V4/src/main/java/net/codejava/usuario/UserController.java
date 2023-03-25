package net.codejava.usuario;

import com.gtbr.ViaCepClient;
import com.gtbr.domain.Cep;

import jakarta.validation.Valid;

import java.io.IOException;
import org.apache.http.client.fluent.*;

import net.codejava.userQualificacao.UserQualificacao;
import net.codejava.userQualificacao.UserQualificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserQualificacaoService userQualificacaoService;

    @RequestMapping("/users")
    public String viewAllUsers(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        List<User> listUsers = service.listAll();
        User userGerente = (User) service.findByUsername(currentUser.getUsername());

        model.addAttribute("userGerente", userGerente);
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @RequestMapping("/profile")
    public String viewUserProfile(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = (User) service.findByUsername(currentUser.getUsername());
        model.addAttribute("user", user);

        List<UserQualificacao> qualificacoesUser = userQualificacaoService.listAll();
        model.addAttribute("qualificacoesUser", qualificacoesUser);

        return "user_profile";
    }

    @RequestMapping("/newuser") // /new/user
    public String showNewUserForm(@Valid User user, BindingResult result, Model model) {

        model.addAttribute("user", user);

        return "new_user";
    }

    /* método para validar se email existe */
    private static void makeAbstractRequest(String email) {

        try {

            Content content = Request.Get("https://emailvalidation.abstractapi.com/v1/?api_key=b026d76b64fc4f3fbbfff8c30b374c8f&email="+email)

                    .execute().returnContent();

            System.out.println("Make Abstract Request");
            System.out.println(content);

            String busca = content.asString();
            String findMe = "\"DELIVERABLE\"";
            int i = busca.indexOf(findMe);

            if (i > 0) {
                System.out.println("Email existe");
            } else {
                System.out.println("Email não existe");
            }

        }
        catch (IOException error) { System.out.println(error); }
    }

    public boolean validaEmail(String email) {
        try {

            Content content = Request.Get("https://emailvalidation.abstractapi.com/v1/?api_key=b026d76b64fc4f3fbbfff8c30b374c8f&email="+email)

                    .execute().returnContent();

            System.out.println("Make Abstract Request");
            System.out.println(content);

            String busca = content.asString();
            String findMe = "\"DELIVERABLE\"";
            int i = busca.indexOf(findMe);

            if (i > 0) {
                System.out.println("Email existe");
                return true;
            } else {
                System.out.println("Email não existe");
                return false;
            }

        }
        catch (IOException error) { System.out.println(error); }

        return false;
    }
    // salvar após cadastrar
    @RequestMapping(value = "/saveuser", method = RequestMethod.POST) // /user/save
    public String saveUser(@ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirectAttributes) {

        System.out.println("Oie");

        /* valida se o email é real */
        // makeAbstractRequest(user.getUsername());

        if (!validaEmail(user.getUsername())) {
            System.out.println("Email inválido.");

            /* erro */
            redirectAttributes.addFlashAttribute("message", "Erro: O email inserido é inválido.");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");

            return "redirect:/newuser";
        }

        /* valida se o email já existe no sistema */
        User existing = service.findByUsername(user.getUsername());
        if (existing != null) {
            System.out.println("Email existe");
            result.rejectValue("username", null, "Email já existe no sistema.");
            return "new_user";
        }

        if (result.hasErrors()) {
            System.out.println("Errou");
            return "errors/new_user";
        }

        /* validação do cep */
        Cep cep = ViaCepClient.findCep(user.getCep());

        // se o cep não existir, cria um erro p/ ser exibido no campo de preenchimento
        if (cep.getCep() == null) {
            System.out.println("Cep não existe");
            FieldError objectError = new FieldError("user", "cep", "CEP não existe!");
            result.addError(objectError);
            return "new_user";
        }

        /* se o cep existir, setta o estado do user com a sigla da UF */
        System.out.println("Cep existe, continue");
        user.setEstado(cep.getUf());

        /* senha */
        user.setPassword("12345");
        String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        /* salva as alterações */
        service.save(user);

        return "redirect:/users";
    }

    // salvar após editar
    @RequestMapping(value = "/saveuseredit", method = RequestMethod.POST) // /user/save
    public String saveUserAfterEdit(@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Errou");
            return "errors/edit_user";
        }

        /* validação do cep */
        Cep cep = ViaCepClient.findCep(user.getCep());

        // se o cep não existir, cria um erro p/ ser exibido no campo de preenchimento
        if (cep.getCep() == null) {
            System.out.println("Cep não existe");
            FieldError objectError = new FieldError("user", "cep", "CEP não existe!");
            result.addError(objectError);
            return "edit_user";
        }

        /* se o cep existir, setta o estado do user com a sigla da UF */
        System.out.println("Cep existe, continue");
        user.setEstado(cep.getUf());

        /* criptografar a senha antes de salvar no bd */
        /*String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);*/

        /* salva as alterações */
        service.save(user);

        /* Verificar role do usuário para definir p qual página ele vai ser redirecionado após salvar alterações */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        System.out.println("Role:");
        String roledouser = authentication.getAuthorities().toString();
        System.out.println(roledouser);

        String vazia = "";
        int sizeee = roledouser.length();
        for (int i = 0; i < sizeee; i++) {
            if (roledouser.charAt(i) != '[' && roledouser.charAt(i) != ']') {
                vazia += roledouser.charAt(i);
            }
        }

        // profissional é redirecionado para o seu perfil
        if (vazia.equals("ROLE_PROFISSIONAL")) {
            return "redirect:/profile";
        }

        // champion ou gerente é redirecionado para a página de users
        return "redirect:/users";
    }

    // editar usuário
    @RequestMapping("/edituser/{id}") // /edit/user/{id}
    public ModelAndView showEditUserForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_user");

        User user = service.get(id);
        mav.addObject("user", user);

        return mav;
    }

    // deletar usuário
    @RequestMapping("/delete/user/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/users";
    }

    // visualizar usuário
    @GetMapping("/viewuser/{id}")
    public String showUserProfile(Model model, @PathVariable(name = "id") Long id,
                                  @AuthenticationPrincipal UserDetails currentUser) {
        User user = service.get(id);
        List<UserQualificacao> qualificacoesUser = userQualificacaoService.listAll();

        User autenticado = (User) service.findByUsername(currentUser.getUsername());
        model.addAttribute("autenticado", autenticado);

        model.addAttribute("user", user);
        model.addAttribute("qualificacoesUser", qualificacoesUser);

        return "view_user";
    }

    /* formulário para alterar a senha */
    @RequestMapping("/user/alterar/senha")
    public String showAlterarSenhaForm(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = (User) service.findByUsername(currentUser.getUsername());
        model.addAttribute("user", user);

        return "alterar_senha";
    }

    /* salvar alteração da senha */
    @RequestMapping("/saveSenha")
    public String saveAlterarSenha(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {

        String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        System.out.println("Tipo de usuário: " + user.getRole());
        service.save(user);

        redirectAttributes.addFlashAttribute("message", "Senha alterada com sucesso!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/user/alterar/senha";
    }

    /* TESTE CEP */
/*
    @GetMapping("/testecep")
    public String testUserCep(Model model) {
        */
/*ViaCEPGWTClient client = new ViaCEPGWTClient();*//*


        Cep cep = ViaCepClient.findCep("00000000");

        String testeCep = cep.toString();

        if (cep.getCep() == null) {
            System.out.println("Não existe");
        } else {
            System.out.println("Existe, pode add");
        }

        model.addAttribute("testeCep", testeCep);
        return "testecep";
    }
*/

}
