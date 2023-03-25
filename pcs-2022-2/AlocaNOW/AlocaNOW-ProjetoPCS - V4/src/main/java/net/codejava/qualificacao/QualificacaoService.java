package net.codejava.qualificacao;

import net.codejava.qualificacao.Qualificacao;
import net.codejava.qualificacao.QualificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QualificacaoService {
    @Autowired
    private QualificacaoRepository repo;

    public List<Qualificacao> listAll() {
        return repo.findAll();
    }

    public void save(Qualificacao qualificacao) {
        repo.save(qualificacao);
    }

    public Qualificacao get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) { repo.deleteById(id); }

    public Qualificacao findNomeAndNivel(String nome, String nivel) {
        return repo.findQualificacaoByNomeAndNivel(nome, nivel);
    }
}
