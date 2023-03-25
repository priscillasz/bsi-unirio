package net.codejava.alocacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlocacaoService {
    @Autowired
    private AlocacaoRepository repo;

    public List<Alocacao> listAll() {
        return repo.findAll();
    }

    public void save(Alocacao alocacao) {
        repo.save(alocacao);
    }

    public Alocacao get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Alocacao> findByStatus(String status) {
        return repo.findAlocacaosByStatus(status);
    }

    public List<Alocacao> findByEdicaoSolicitada(String solicitada) {
        return repo.findAlocacaosByEdicaoSolicitada(solicitada);
    }

    public List<Alocacao> findByDesalocacaoSolicitada(String solicitada) {
        return repo.findAlocacaosByDesalocacaoSolicitada(solicitada);
    }
}
