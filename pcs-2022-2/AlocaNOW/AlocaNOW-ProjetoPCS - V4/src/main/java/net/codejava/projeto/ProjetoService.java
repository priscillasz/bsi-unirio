package net.codejava.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repo;

    public List<Projeto> listAll() {
        return repo.findAll();
    }

    public void save(Projeto projeto) {
        repo.save(projeto);
    }

    public Projeto get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Projeto findByNome(String nome) {
        return repo.findProjetoByNome(nome);
    }
}
