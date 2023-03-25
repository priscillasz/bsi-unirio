package net.codejava.sugestao;

import net.codejava.alocacao.Alocacao;
import net.codejava.alocacao.AlocacaoService;
import net.codejava.projeto.Projeto;
import net.codejava.projeto.ProjetoNecessidade;
import net.codejava.projeto.ProjetoNecessidadeService;
import net.codejava.projeto.ProjetoService;
import net.codejava.userQualificacao.UserQualificacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SugestaoController {

    @Autowired
    private SugestaoService sugestaoService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private ProjetoNecessidadeService projetoNecessidadeService;

    @Autowired
    private AlocacaoService alocacaoService;

    /* gerar sugestão para a necessidade escolhida pelo usuário */
    /*@RequestMapping("/projeto/necessidade/sugestao")
    public String gerarSugestao() {

        return "sugestao";
    }*/

    /* listar sugestões geradas - teste */
    @RequestMapping("/projeto/sugestoes")
    public String listarSugestoes(Model model) {
        List<Sugestao> listSugestoes = sugestaoService.listAll();


        model.addAttribute("listSugestoes", listSugestoes);
        return "sugestoes";
    }

    @RequestMapping("/projeto/necessidade/sugestao/{id}")
    public String exemploSugestao(Model model, @PathVariable(name="id") Long id) {

        Sugestao sugestao = sugestaoService.findByNecessidade(id);
        model.addAttribute("sugestao", sugestao);

        return "sugestao";
    }

    /* salvar solicitação de alocação */
    @RequestMapping(value = "/saveSolicitacaoAlocacao", method = RequestMethod.POST)
    public String saveSolicitacao(@ModelAttribute("Alocacao") Alocacao alocacao, @ModelAttribute("Sugestao") Sugestao sugestao) {
        /* assim que salvar a solicitação, o status da alocação muda p/ solicitado */
        alocacao.setStatus("Solicitado");

        alocacaoService.save(alocacao);

        sugestaoService.save(sugestao);

        /*return "redirect:/projeto/sugestoes";*/

        return "redirect:/view/projeto/"+alocacao.getIdProjeto();
    }

    /* solicitar alocação */
    @RequestMapping("/projeto/sugestoes/solicitar/{id}")
    public String solicitarAlocacao(Model model, @PathVariable(name="id") Long id) {

        Sugestao sugestao = sugestaoService.get(id);
        Projeto projeto = projetoService.get(sugestao.getProjetoId());
        ProjetoNecessidade projetoNecessidade = projetoNecessidadeService.get(sugestao.getNecessidadeId());

        sugestao.setSolicitado(true);

        model.addAttribute("sugestao", sugestao);
        model.addAttribute("projeto", projeto);
        model.addAttribute("necessidade", projetoNecessidade);

        Alocacao alocacao = new Alocacao();

        alocacao.setIdProjeto(projeto.getId());
        alocacao.setIdProfissional(sugestao.getProfissionalId());
        alocacao.setIdGerente(projeto.getIdGerente());
        alocacao.setNomeGerente(projeto.getNomeGerente());
        alocacao.setNomeProjeto(projeto.getNome());
        alocacao.setNomeProfissional(sugestao.getNomeProfissional());
        alocacao.setInicioAlocacao(projetoNecessidade.getDataInicio());
        alocacao.setFimAlocacao(projetoNecessidade.getDataFim());
        alocacao.setCargaHoraria(projetoNecessidade.getHoraDia());
        alocacao.setTipoSolicitacao("Alocação");
        alocacao.setDesalocacaoSolicitada("não"); //

        model.addAttribute("alocacao", alocacao);

        return "solicitar_alocacao";
    }
}