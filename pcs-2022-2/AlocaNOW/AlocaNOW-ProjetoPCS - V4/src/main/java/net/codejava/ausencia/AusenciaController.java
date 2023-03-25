package net.codejava.ausencia;

import net.codejava.usuario.User;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class AusenciaController {
    @Autowired
    private AusenciaService ausenciaService;

    @Autowired
    private UserService userService;

    @RequestMapping("/ausencias")
    public String listarAusencias(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        List<Ausencia> listAusencias = ausenciaService.listAll();
        User user = (User) userService.findByUsername(currentUser.getUsername());

        model.addAttribute("user", user);
        model.addAttribute("listAusencias", listAusencias);

        return "ausencias";
    }

    /* form p/ cadastrar nova ausência */
    @RequestMapping("/new/ausencia") // /new/ausencia
    public String showNewAusenciaForm(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        Ausencia ausencia = new Ausencia();

        User user = (User) userService.findByUsername(currentUser.getUsername());
        // model.addAttribute("user", user);

        model.addAttribute("ausencia", ausencia);

        return "new_ausencia";
    }

    /* salvar ausência após cadastro */
    @RequestMapping(value = "/saveAusencia", method = RequestMethod.POST) // /save/ausencia // /ausencia/save
    public String saveAusencia(@ModelAttribute("ausencia") Ausencia ausencia, BindingResult result,
                               @AuthenticationPrincipal UserDetails currentUser) {
        // validar se a data inicial é menor que a data final
        // caso não for, retornar o erro
        if (ausencia.getDataInicio().after(ausencia.getDataFim()) || ausencia.getDataFim().before(ausencia.getDataInicio())) {
            System.out.println("Data inválida!");
            FieldError objectError = new FieldError("ausencia", "dataInicio", "Data inválida");
            result.addError(objectError);
            return "new_ausencia";

        }

        /* validar se a ausência é maior que 12 meses */
        LocalDate inicio = convertToLocalDateViaInstant(ausencia.getDataInicio());
        LocalDate fim = convertToLocalDateViaInstant(ausencia.getDataFim());

        Period age = Period.between(inicio, fim);
        int years = age.getYears();

        System.out.println("Months between: "+years);
        if (years == 0) {
            System.out.println("ausência com até 12 meses");

        } else if (years > 0){
            System.out.println("ausência com mais de 12 meses");

            FieldError objectError = new FieldError("ausencia", "dataFim", "Maior que 12 meses");
            result.addError(objectError);
            return "new_ausencia";
        }

        //
        User user = (User) userService.findByUsername(currentUser.getUsername());
        ausencia.setIdProfissional(user.getId());
        ausencia.setProfissional(user.getNome());

        /* validar se já existe uma ausência nesse período */
        List<Ausencia> ausenciasProfissional = ausenciaService.findByProfissional(ausencia.getIdProfissional());

        /*for (int i = 0; i < ausenciasProfissional.size(); i++) {
            if (!(ausencia.getDataInicio().after(ausenciasProfissional.get(i).getDataInicio()) ||
                    ausencia.getDataInicio().before(ausenciasProfissional.get(i).getDataFim())) ||
            !(ausencia.getDataFim().before(ausenciasProfissional.get(i).getDataInicio()) ||
                    ausencia.getDataFim().after((ausenciasProfissional.get(i).))));

        }
        //*/

        /* salvar */
        ausenciaService.save(ausencia);

        return "redirect:/ausencias";
    }

    /* converter Date para LocalDate */
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    /* salvar após edição */
    @RequestMapping(value = "/saveAusenciaEdit", method = RequestMethod.POST) // /save/ausencia // /ausencia/save
    public String saveAusenciaAfterEdit(@ModelAttribute("ausencia") Ausencia ausencia, BindingResult result,
                               @AuthenticationPrincipal UserDetails currentUser) {
        // validar se a data inicial é menor que a data final
        // caso não for, retornar o erro
        if (ausencia.getDataInicio().after(ausencia.getDataFim()) || ausencia.getDataFim().before(ausencia.getDataInicio())) {
            System.out.println("Data inválida!");
            FieldError object2Error = new FieldError("ausencia", "dataInicio", "Data inválida");
            result.addError(object2Error);
            return "edit_ausencia";
        }

        User user = (User) userService.findByUsername(currentUser.getUsername());
        ausencia.setIdProfissional(user.getId());
        ausencia.setProfissional(user.getNome());

        ausenciaService.save(ausencia);

        return "redirect:/ausencias";
    }

    /* form p/ editar ausência */
    @RequestMapping("/edit/ausencia/{id}") // /edit/ausencia/{id}
    public ModelAndView showEditAusenciaForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_ausencia");

        Ausencia ausencia = ausenciaService.get(id);
        mav.addObject("ausencia", ausencia);

        return mav;
    }

    /* Deletar ausência */
    @RequestMapping("/delete/ausencia/{id}") // /delete/ausencia/{id}
    public String deleteAusencia(@PathVariable(name = "id") Long id) {
        ausenciaService.delete(id);

        return "redirect:/ausencias";
    }
}
