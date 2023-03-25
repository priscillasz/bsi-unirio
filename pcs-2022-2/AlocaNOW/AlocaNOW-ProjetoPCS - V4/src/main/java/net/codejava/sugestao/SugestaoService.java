package net.codejava.sugestao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SugestaoService {
    @Autowired
    private SugestaoRepository repo;

    public List<Sugestao> listAll() {
        return repo.findAll();
    }

    public void save(Sugestao sugestao) {
        repo.save(sugestao);
    }

    public Sugestao get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Sugestao findByNecessidade(Long idNecessidade) {
        return repo.findSugestaoByNecessidadeId(idNecessidade);
    }
}