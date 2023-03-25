package net.codejava.projeto;

import net.codejava.alocacao.Alocacao;
import net.codejava.alocacao.AlocacaoService;
import net.codejava.sugestao.SugestaoService;
import net.codejava.usuario.User;
import net.codejava.usuario.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjetoNecessidadeService projetoNecessidadeService;

    @Autowired
    private AlocacaoService alocacaoService;

    // listar projetos
    @RequestMapping("/projetos")
    public String listarProjetos(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        List<Projeto> listProjetos = projetoService.listAll();
        User user = (User) userService.findByUsername(currentUser.getUsername());

        model.addAttribute("user", user);
        model.addAttribute("listProjetos", listProjetos);

        return "projetos";
    }

    // visualizar projeto
    @GetMapping("/view/projeto/{id}")
    public String showProjetoDetails(Model model, @PathVariable(name = "id") Long id,
                                     @AuthenticationPrincipal UserDetails currentUser) {

        /* dados do usuário autenticado */
        User user = (User) userService.findByUsername(currentUser.getUsername());
        model.addAttribute("user", user);

        /* dados do projeto que está sendo visualizao */
        Projeto projeto = projetoService.get(id);
        model.addAttribute("projeto", projeto);

        /* listagem de todas as necessidades cadastradas */
        List<ProjetoNecessidade> listNecessidades = projetoNecessidadeService.listAll();
        model.addAttribute("listNecessidades", listNecessidades);

        /* listar profissionais alocados no projeto */
        List<Alocacao> listAlocacoes = alocacaoService.listAll();
        model.addAttribute("listAlocacoes", listAlocacoes);

        return "view_projeto";
    }

    // formulário de cadastro de projeto
    @RequestMapping("/new/projeto")
    public String showNewProjetoForm(Model model) {
        Projeto projeto = new Projeto();

        model.addAttribute("projeto", projeto);

        return "new_projeto";
    }

    // formulário de edição de projeto
    @RequestMapping("/edit/projeto/{id}")
    public ModelAndView showEditProjetoForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_projeto");

        Projeto projeto = projetoService.get(id);
        mav.addObject("projeto", projeto);

        return mav;
    }

    // salvar projeto após cadastro
    @RequestMapping(value = "/saveProjeto", method = RequestMethod.POST)
    public String saveProjeto(@ModelAttribute("projeto") Projeto projeto, BindingResult result,
                              @AuthenticationPrincipal UserDetails currentUser) {

        /* validar se já existe um projeto com o mesmo nome */
        Projeto existing = projetoService.findByNome(projeto.getNome());
        if (existing != null) {
            System.out.println("Nome de projeto já existe");
            result.rejectValue("nome", null, "Já existe um projeto com o mesmo nome.");
            return "new_projeto";
        }

        if (result.hasErrors()) {
            System.out.println("Errou");
            return "errors/new_projeto";
        }

        // validar se a data inicial é menor que a data final
        // caso não for, retornar o erro
        if (projeto.getDataInicio().after(projeto.getDataFinal()) || projeto.getDataFinal().before(projeto.getDataInicio())) {
            System.out.println("Data inválida!");
            FieldError objectError = new FieldError("projeto", "dataInicio", "Data inválida");
            result.addError(objectError);
            return "new_projeto";
        }

        // setta o nome e id do gerente com os dados do gerente que está logado
        User user = (User) userService.findByUsername(currentUser.getUsername());
        projeto.setIdGerente(user.getId());
        projeto.setNomeGerente(user.getNome());

        // salva os dados do projeto
        projetoService.save(projeto);

        // redireciona p/ menu de projetos
        return "redirect:/projetos";
    }

    // salvar projeto após edição
    @RequestMapping(value = "/saveProjetoEdit", method = RequestMethod.POST)
    public String saveProjetoAfterEdit(@ModelAttribute("projeto") Projeto projeto, BindingResult result,
                              @AuthenticationPrincipal UserDetails currentUser) {

        // validar se a data inicial é menor que a data final
        // caso não for, retornar o erro
        if (projeto.getDataInicio().after(projeto.getDataFinal()) || projeto.getDataFinal().before(projeto.getDataInicio())) {
            System.out.println("Data inválida!");
            FieldError objectError = new FieldError("projeto", "dataInicio", "Data inválida");
            result.addError(objectError);
            return "edit_projeto";
        }

        // setta o nome e id do gerente com os dados do gerente que está logado
        User user = (User) userService.findByUsername(currentUser.getUsername());
        projeto.setIdGerente(user.getId());
        projeto.setNomeGerente(user.getNome());

        Long projId = projeto.getId();

        // salva os dados do projeto
        projetoService.save(projeto);

        // redireciona p/ menu de projetos
        return "redirect:/view/projeto/"+projId;
    }

    // deletar projeto
    @RequestMapping("/delete/projeto/{id}")
    public String deleteProjeto(@PathVariable(name = "id") Long id) {
        projetoService.delete(id);

        // teste
        System.out.println("Projeto "+id+" removido");

        return "redirect:/projetos";
    }
}
