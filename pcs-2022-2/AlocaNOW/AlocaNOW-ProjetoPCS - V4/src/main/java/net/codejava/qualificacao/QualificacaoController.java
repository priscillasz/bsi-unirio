package net.codejava.qualificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class QualificacaoController {
   // @Autowired
    private final QualificacaoService qualificacaoService;

    @Autowired
    public QualificacaoController(QualificacaoService qualificacaoService) {
        this.qualificacaoService = qualificacaoService;
    }

    @Autowired
    private QualificacaoRepository qualificacaoRepository;

    @RequestMapping("/qualificacoes")
    public String listarQualificacoes(Model model) {
        List<Qualificacao> listQualificacoes = qualificacaoService.listAll();
        model.addAttribute("listQualificacoes", listQualificacoes);

        return "qualificacoes";
    }

    @RequestMapping("/qualificacao/new") // /new/qualificacao
    public String showNewQualificacaoForm(Model model) {
        Qualificacao qualificacao = new Qualificacao();
        model.addAttribute("qualificacao", qualificacao);

        return "new_qualificacao";
    }

    @RequestMapping(value = "/saveQualificacao", method = RequestMethod.POST)
    public String saveQualificacao(@ModelAttribute("qualificacao") Qualificacao qualificacao,
                                   RedirectAttributes redirectAttributes) {

        Qualificacao qualifToAdd = qualificacaoService.findNomeAndNivel(qualificacao.getNome(), qualificacao.getNivel());

        if (qualifToAdd == null) {
            System.out.println("qualificação ainda não foi cadastrada");

            qualificacaoService.save(qualificacao);

            /* mensagem de sucesso após salvar vinculação */
            redirectAttributes.addFlashAttribute("message", "Qualificação cadastrada com sucesso!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } else {
            System.out.println("qualificação já foi cadastrada anteriormente");

            /* erro */
            redirectAttributes.addFlashAttribute("message", "Qualificação já foi cadastrada anteriormente!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }

        return "redirect:/qualificacoes";
    }

    @RequestMapping("/qualificacao/edit/{id}") // /edit/qualificacao/{id}
    public ModelAndView showEditQualificacaoForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_qualificacao");

        Qualificacao qualificacao = qualificacaoService.get(id);

        mav.addObject("qualificacao", qualificacao);

        return mav;
    }

    @RequestMapping("/qualificacao/delete/{id}") // /delete/qualificacao/{id}
    public String deleteQualificacao(@PathVariable(name = "id") Long id, RedirectAttributes redirectAttributes) {
        qualificacaoService.delete(id);

        redirectAttributes.addFlashAttribute("message", "Qualificação removida com sucesso.");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/qualificacoes";
    }
}