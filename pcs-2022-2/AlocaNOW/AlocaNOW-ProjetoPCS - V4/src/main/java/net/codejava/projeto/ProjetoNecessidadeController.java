package net.codejava.projeto;

import net.codejava.qualificacao.Qualificacao;
import net.codejava.qualificacao.QualificacaoService;
import net.codejava.usuario.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProjetoNecessidadeController {
    @Autowired
    private ProjetoNecessidadeService projetoNecessidadeService;

    @Autowired
    private UserService userService;

    @Autowired
    private QualificacaoService qualificacaoService;

    @Autowired
    private ProjetoService projetoService;


    // n precisa
    @RequestMapping("/projetos/necessidades")
    public String listarProjetosNecessidades(Model model, @AuthenticationPrincipal UserDetails currentUsers){
        List<ProjetoNecessidade> listProjetoNecessidades = projetoNecessidadeService.listAll();

        return "projeto_necessidades";
    }

    /* Formulário p/ cadastrar requisitos de cada profissional a ser solicitado */
    @RequestMapping("/new/projeto/necessidade/{id}")
    public String showNewProjetoNecessidadeForm(Model model,  @PathVariable(name = "id") Long id) {

        // pegar id, area e subarea do projeto q recebe as necessidades
        Projeto projeto = projetoService.get(id);
        Long projetoId = projeto.getId();
        String projetoArea = projeto.getAreaAtuacao();
        String projetoSubArea = projeto.getSubAreaAtuacao();

        model.addAttribute("projetoId", projetoId);
        model.addAttribute("projetoArea", projetoArea);
        model.addAttribute("projetoSubArea", projetoSubArea);

        ProjetoNecessidade projetoNecessidade = new ProjetoNecessidade();
        projetoNecessidade.setIdProjeto(projetoId);
        projetoNecessidade.setAreaProjeto(projetoArea);
        projetoNecessidade.setSubAreaProjeto(projetoSubArea);
        model.addAttribute("necessidadeProjeto", projetoNecessidade);

        /* listar todas as qualificacoes do sistema */
        List<Qualificacao> listQualificacoes = qualificacaoService.listAll();
        model.addAttribute("listQualificacoes", listQualificacoes);

        return "new_projeto_necessidade";
    }

    @RequestMapping(value = "/saveProjetoNecessidade", method = RequestMethod.POST)
    public String saveProjetoNecessidade(@ModelAttribute("projetoNecessidade") ProjetoNecessidade projetoNecessidade,
                                         BindingResult result, RedirectAttributes redirectAttributes) {

        // validar se a data inicial é menor que a data final
        // caso não for, retornar o erro
        if (projetoNecessidade.getDataInicio().after(projetoNecessidade.getDataFim()) ||
                projetoNecessidade.getDataFim().before(projetoNecessidade.getDataInicio())) {
            System.out.println("Data inválida!");
            FieldError objectError = new FieldError("projetoNecessidade", "dataInicio", "Data inválida");
            result.addError(objectError);
            return "new_projeto_necessidade";
        }

        /* validar se o fim da alocação é antes do fim do projeto */
        Long projetoId = projetoNecessidade.getIdProjeto();
        Projeto projeto = projetoService.get(projetoId);

        if (projetoNecessidade.getDataFim().after(projeto.getDataFinal())) {
            System.out.println("Fim da alocação é depois do fim do projeto");

            redirectAttributes.addFlashAttribute("message", "Erro: A data final da necessidade é maior que a data final do projeto.");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");

            return "redirect:/view/projeto/"+projetoId;
        }

        /* puxar nome da qualificação através da id */
        Qualificacao qualificacao1 = qualificacaoService.get(projetoNecessidade.getIdQualificacao1());
        projetoNecessidade.setQualif1(qualificacao1.getNome()+" "+qualificacao1.getNivel());
        Qualificacao qualificacao2 = qualificacaoService.get(projetoNecessidade.getIdQualificacao2());
        projetoNecessidade.setQualif2(qualificacao2.getNome()+" "+qualificacao2.getNivel());
        Qualificacao qualificacao3 = qualificacaoService.get(projetoNecessidade.getIdQualificacao3());
        projetoNecessidade.setQualif3(qualificacao3.getNome()+" "+qualificacao3.getNivel());

        /* salvar */
        //Long projId = projetoNecessidade.getIdProjeto();

        projetoNecessidadeService.save(projetoNecessidade);

        return "redirect:/view/projeto/"+projetoId;
    }

    // tirar
    @RequestMapping("/delete/projetoNecessidade/{id}")
    public String deleteProjetoNecessidade(@PathVariable(name="id") Long id){
        ProjetoNecessidade necessidade = projetoNecessidadeService.get(id);
        Projeto projeto = projetoService.get(necessidade.getIdProjeto());

        projetoNecessidadeService.delete(id);

       /* return "redirect:/projetos";*/
        return "redirect:/view/projeto/"+projeto.getId();
    }
}
