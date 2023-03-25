package net.codejava.userQualificacao;

import net.codejava.qualificacao.Qualificacao;
import net.codejava.qualificacao.QualificacaoService;
import net.codejava.usuario.User;
import net.codejava.usuario.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserQualificacaoController {
    private final UserQualificacaoService userQualificacaoService;

    @Autowired
    public UserQualificacaoController(UserQualificacaoService userQualificacaoService) {
        this.userQualificacaoService = userQualificacaoService;
    }

    @Autowired
    private UserService userService;

    @Autowired
    private QualificacaoService qualificacaoService;

    /* vincular qualificações a um usuário */
    @RequestMapping("/qualificacoes/vincular")
    public String showVincularQualificacoesForm(Model model, @AuthenticationPrincipal UserDetails currentUser) {

        /* informações do usuário que está logado */
        User user = (User) userService.findByUsername(currentUser.getUsername());
        model.addAttribute("user", user);

        /* listar todas as qualificacoes do sistema */
        List<Qualificacao> listQualificacoes = qualificacaoService.listAll();
        model.addAttribute("listQualificacoes", listQualificacoes);

        /* qualificação que está sendo vinculada */
        UserQualificacao userQualificacao = new UserQualificacao();
        model.addAttribute("userQualificacao", userQualificacao);

        return "vincular_qualificacoes";
    }

    @RequestMapping(value = "/saveUserQualificacao", method = RequestMethod.POST)
    public String saveUserQualificacao(@ModelAttribute("UserQualificacao") UserQualificacao userQualificacao,
                                       @AuthenticationPrincipal UserDetails currentUser, RedirectAttributes redirectAttributes) {

        /* informações do usuário que está logado */
        User user = (User) userService.findByUsername(currentUser.getUsername());

        /* settar id e email do usuário que vinculou a qualificação */
        System.out.println("Chegou aqui");
        userQualificacao.setIdUser(user.getId());
        System.out.println("Id do usuário: " + userQualificacao.getIdUser());
        userQualificacao.setUsuario(user.getUsername());
        System.out.println("Email do usuário: " + userQualificacao.getUsuario());

        /* puxar nome da qualificação através da id */
        Qualificacao qualificacao = qualificacaoService.get(userQualificacao.getIdQualificacao());
        userQualificacao.setNomeQualificacao(qualificacao.getNome()+" "+qualificacao.getNivel());

        /* validar se qualificação já foi vinculada anteriormente */
        UserQualificacao qualifToAdd = userQualificacaoService.findByQualifAndUser(userQualificacao.getIdQualificacao(),
                userQualificacao.getIdUser());

        System.out.println("User: " + userQualificacao.getIdUser());
        System.out.println("Qualificação: " + userQualificacao.getIdQualificacao());

        if (qualifToAdd == null) {
            System.out.println("qualificação ainda não foi vinculada");

            /* salvar */
            userQualificacaoService.save(userQualificacao);

            /* mensagem de sucesso após salvar vinculação */
            redirectAttributes.addFlashAttribute("message", "Qualificação '" + userQualificacao.getNomeQualificacao() + "' vinculada com sucesso!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        } else {
            System.out.println("qualificação já foi vinculada anteriormente");

            /* erro */
            redirectAttributes.addFlashAttribute("message", "Qualificação '" + userQualificacao.getNomeQualificacao() + "' já foi vinculada anteriormente!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }

        return "redirect:/qualificacoes/vincular";
    }
}