package net.codejava.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoNecessidadeService {
    @Autowired
    private ProjetoNecessidadeRepository repo;

    public List<ProjetoNecessidade> listAll(){return repo.findAll();}

    public void save(ProjetoNecessidade pn){repo.save(pn);}

    public ProjetoNecessidade get(Long id){return repo.findById(id).get();}

    public void delete(Long id){repo.deleteById(id);}

}
