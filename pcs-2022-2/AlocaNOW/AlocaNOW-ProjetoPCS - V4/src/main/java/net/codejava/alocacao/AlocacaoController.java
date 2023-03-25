package net.codejava.alocacao;

import net.codejava.projeto.Projeto;
import net.codejava.projeto.ProjetoService;
import net.codejava.usuario.User;
import net.codejava.usuario.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AlocacaoController {

    @Autowired
    private AlocacaoService alocacaoService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender mailSender;

    /* listar todas as alocações confirmadas */
    @RequestMapping("/view/alocacoes")
    public String listAllAlocacoes(Model model) {
        List<Alocacao> listAlocacoes = alocacaoService.listAll();
        model.addAttribute("listAlocacoes", listAlocacoes);

        return "all_alocacoes";
    }
    /* listar solicitações de alocação */
    @RequestMapping("/alocacoes")
    public String listarAlocacoes(Model model) {
        List<Alocacao> listAlocacoes = alocacaoService.listAll();
        model.addAttribute("listAlocacoes", listAlocacoes);

        return "alocacoes";
    }

    /* listar solicitações de edição de alocação */
    @RequestMapping("/edicoes")
    public String listarSolicitacoesEdicao(Model model) {
        List<Alocacao> listAlocacoes = alocacaoService.listAll();
        model.addAttribute("listAlocacoes", listAlocacoes);

        return "edicoes";
    }

    /* listar solicitações de desalocação */
    @RequestMapping("/desalocacoes")
    public String listarDesalocacoes(Model model) {
        List<Alocacao> listAlocacoes = alocacaoService.listAll();
        model.addAttribute("listAlocacoes", listAlocacoes);

        return "desalocacoes";
    }

    /* save after aceitar ou rejeitar solicitação de alocação */
    @RequestMapping("/saveAlocacao")
    public String saveAlocacao(@ModelAttribute("Alocacao") Alocacao alocacao) {

        alocacaoService.save(alocacao);

        /* busca email do gerente e do profissional envolvidos */
        User gerente = userService.get(alocacao.getIdGerente());
        String emailGerente = gerente.getUsername();

        User profissional = userService.get(alocacao.getIdProfissional());
        String emailProfissional = profissional.getUsername();

        String emailAlocaNow = "alocanowpcs@gmail.com";

        /* caso solicitação seja alocada */
        if (alocacao.getStatus().equals("Alocado")) {
            /* envia email para o gerente */
            enviaEmail(emailAlocaNow, emailGerente, "Confirmação de Alocação",
                    "Sua solicitação de alocação do profissional " + alocacao.getNomeProfissional() +
                    " para o projeto " + alocacao.getNomeProjeto() + " de "+ alocacao.getInicioAlocacao() +
                            " até " + alocacao.getFimAlocacao() + " foi aceita!");

            /* envia email para o profissional */
            enviaEmail(emailAlocaNow, emailProfissional, "Notificação de Alocação",
                    "Você foi alocado no projeto " + alocacao.getNomeProjeto() +
                            " de "+ alocacao.getInicioAlocacao() + " até " + alocacao.getFimAlocacao() + "!");
        }

        /* caso solicitação seja rejeitada */
        if (alocacao.getStatus().equals("Rejeitado")) {
            /* envia email para o gerente */
            enviaEmail(emailAlocaNow, emailGerente, "Rejeição de Solicitação de Alocação",
                    "Sua solicitação de alocação do profissional " + alocacao.getNomeProfissional() +
                            " para o projeto " + alocacao.getNomeProjeto() + " de "+ alocacao.getInicioAlocacao() +
                            " até " + alocacao.getFimAlocacao() + " foi rejeitada.");

        }

        return "redirect:/alocacoes";
    }

    /* método para enviar email */
    public void enviaEmail(String from, String to, String assunto, String mensagem) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(assunto);
        message.setText(mensagem);

        mailSender.send(message);
    }

    /* form confirmar alocação de sugestão */
    @RequestMapping("/alocacoes/alocar/{id}")
    public String alocarProfissional(Model model, @PathVariable(name = "id") Long id) {
        Alocacao alocacao = alocacaoService.get(id);
//        alocacao.setStatus("Alocado");
        Projeto projeto = projetoService.get(alocacao.getIdProjeto());

        model.addAttribute("alocacao", alocacao);
        model.addAttribute("projeto", projeto);

        return "alocar_sugestao";
    }

    /* form editar */

    /* save */
  /*  @RequestMapping("/alocacoes/alocacao/save")
    public String saveAlocacao() {

//        alocacaoService.save(alocacao);

        return "redirect:/alocacoes";
    }*/

    /* solicitação de edição de alocação */
    @RequestMapping("/projeto/solicitar/edicao/{id}")
    public String solicitarEdicaoAlocacao(Model model, @PathVariable(name="id") Long id) {
        Alocacao alocacao = alocacaoService.get(id);
        alocacao.setEdicaoSolicitada("sim"); //

        model.addAttribute("alocacao", alocacao);

        return "solicitar_edicao";
    }

    @RequestMapping("/saveSolicitacaoEdicaoAlocacao")
    public String saveSolicitacaoEdicaoAlocacao(@ModelAttribute("Alocacao") Alocacao alocacao) {

        alocacaoService.save(alocacao);

        return "redirect:/projetos";
    }

    /* editar alocação */
    @RequestMapping("/alocacao/editar/{id}")
    public String editarAlocacao(Model model, @PathVariable(name = "id") Long id) {
        Alocacao alocacao = alocacaoService.get(id);

        Projeto projeto = projetoService.get(alocacao.getIdProjeto());

        alocacao.setEdicaoSolicitada("não");

        model.addAttribute("alocacao", alocacao);
        model.addAttribute("projeto", projeto);

        return "editar_alocacao";
    }

    @RequestMapping("/saveEdicaoAlocacao")
    public String saveEdicao(@ModelAttribute("Alocacao") Alocacao alocacao) {

//        alocacao.setFimAlocacao(alocacao.getSolicitacaoFimAlocacao());

        // if editar
        if (alocacao.getStatusEdicao().equals("ok")) {
            System.out.println("edição ok?");
            alocacao.setFimAlocacao(alocacao.getSolicitacaoFimAlocacao());
            System.out.println("edição ok");
        }

        alocacaoService.save(alocacao);

        /* busca email do gerente e do profissional envolvidos */
        User gerente = userService.get(alocacao.getIdGerente());
        String emailGerente = gerente.getUsername();

        User profissional = userService.get(alocacao.getIdProfissional());
        String emailProfissional = profissional.getUsername();

        String emailAlocaNow = "alocanowpcs@gmail.com";

        /* caso solicitação seja alocada */
        if (alocacao.getStatusEdicao().equals("ok")) {
            /* envia email para o gerente */
            enviaEmail(emailAlocaNow, emailGerente, "Confirmação de Edição de Alocação",
                    "Sua solicitação de edição de alocação do profissional " + alocacao.getNomeProfissional() +
                            " para o projeto " + alocacao.getNomeProjeto() + " de "+ alocacao.getInicioAlocacao() +
                            " até " + alocacao.getFimAlocacao() + " foi aceita!");

            /* envia email para o profissional */
            enviaEmail(emailAlocaNow, emailProfissional, "Notificação de Alocação",
                    "Sua alocação no projeto " + alocacao.getNomeProjeto() +
                            "foi atualizada. Período alocado: "+ alocacao.getInicioAlocacao() + " até " + alocacao.getFimAlocacao());
        }

        /* caso solicitação seja rejeitada */
        if (alocacao.getStatusEdicao().equals("no")) {
            /* envia email para o gerente */
            enviaEmail(emailAlocaNow, emailGerente, "Rejeição de Solicitação de Edição de Alocação",
                    "Sua solicitação de edição de alocação do profissional " + alocacao.getNomeProfissional() +
                            " para o projeto " + alocacao.getNomeProjeto() + " de "+ alocacao.getInicioAlocacao() +
                            " até " + alocacao.getFimAlocacao() + " foi rejeitada.");

        }

        return "redirect:/edicoes";
    }


    /* solicitação de desalocação */
    @RequestMapping("/projeto/solicitar/desalocacao/{id}")
    public String solicitarDesalocacao(Model model, @PathVariable(name="id") Long id) {
        Alocacao alocacao = alocacaoService.get(id);
        alocacao.setDesalocacaoSolicitada("sim"); //

        model.addAttribute("alocacao", alocacao);

        return "solicitar_desalocacao";
    }

    @RequestMapping("/saveSolicitacaoDesalocacao")
    public String saveSolicitacaoDesalocacao(@ModelAttribute("Alocacao") Alocacao alocacao) {

        alocacaoService.save(alocacao);

        return "redirect:/projetos";
    }

    /* desalocar profissional */
    @RequestMapping("/alocacao/desalocar/{id}")
    public String desalocarProfissional(Model model, @PathVariable(name = "id") Long id) {
//        alocacaoService.delete(id);
        Alocacao alocacao = alocacaoService.get(id);

        Projeto projeto = projetoService.get(alocacao.getIdProjeto());

        alocacao.setDesalocacaoSolicitada("não"); //

        model.addAttribute("alocacao", alocacao);
        model.addAttribute("projeto", projeto);

        return "desalocar_profissional";
    }

    @RequestMapping("/saveDesalocacao")
    public String saveDesalocacao(@ModelAttribute("Alocacao") Alocacao alocacao) {

        /*if (alocacao.getStatus() == "Desalocado") {

        } else if (alocacao.getStatus() == "Alocado") {
            alocacao.setDesalocacaoSolicitada("não");
        }*/

        alocacaoService.save(alocacao);

        /* busca email do gerente e do profissional envolvidos */
        User gerente = userService.get(alocacao.getIdGerente());
        String emailGerente = gerente.getUsername();

        User profissional = userService.get(alocacao.getIdProfissional());
        String emailProfissional = profissional.getUsername();

        String emailAlocaNow = "alocanowpcs@gmail.com";

        /* caso solicitação seja alocada */
        if (alocacao.getStatus().equals("Desalocado")) {
            /* envia email para o gerente */
            enviaEmail(emailAlocaNow, emailGerente, "Confirmação de Desalocação",
                    "Sua solicitação de desalocação do profissional " + alocacao.getNomeProfissional() +
                            " para o projeto " + alocacao.getNomeProjeto() + " foi aceita!");

            /* envia email para o profissional */
            enviaEmail(emailAlocaNow, emailProfissional, "Notificação de Desalocação",
                    "Você foi desalocado do projeto " + alocacao.getNomeProjeto() + ".");
        }

        /* caso solicitação seja rejeitada */
        if (alocacao.getStatus().equals("Alocado")) {
            /* envia email para o gerente */
            enviaEmail(emailAlocaNow, emailGerente, "Rejeição de Solicitação de Desalocação",
                    "Sua solicitação de desalocação do profissional " + alocacao.getNomeProfissional() +
                            " para o projeto " + alocacao.getNomeProjeto() + " foi rejeitada.");
        }


        return "redirect:/desalocacoes";
    }

    /* menu de solicitações */
    @RequestMapping("/solicitacoes")
    public String menuSolicitacoes(Model model) {

        /* solicitações de alocação */
        List<Alocacao> alocacoes = alocacaoService.findByStatus("Solicitado");

        System.out.println("Qtd de solicitações de alocação: " + alocacoes.size());

        /* solicitações de edição */
        List<Alocacao> edicoes = alocacaoService.findByEdicaoSolicitada("sim");

        /* solicitações de desalocação */
        List<Alocacao> desalocacoes = alocacaoService.findByDesalocacaoSolicitada("sim");

        model.addAttribute("alocacoes", alocacoes);
        model.addAttribute("edicoes", edicoes);
        model.addAttribute("desalocacoes", desalocacoes);

        return "menu_solicitacoes";
    }
}
