package net.codejava.ausencia;

import net.codejava.ausencia.Ausencia;
import net.codejava.ausencia.AusenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AusenciaService {
    @Autowired
    private AusenciaRepository repo;

    public List<Ausencia> listAll() {
        return repo.findAll();
    }

    public void save(Ausencia ausencia) {
        repo.save(ausencia);
    }

    public Ausencia get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Ausencia> findByProfissional(Long idProfissional) {
        return repo.findAusenciasByIdProfissional(idProfissional);
    }
}
