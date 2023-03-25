package net.codejava.userQualificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQualificacaoService {
    @Autowired
    private UserQualificacaoRepository repo;

    public List<UserQualificacao> listAll() { return repo.findAll(); }

    public void save(UserQualificacao pq) { repo.save(pq); }

    public UserQualificacao get(Long id){ return repo.findById(id).get(); }

    public void delete(Long id) { repo.deleteById(id); }

    public boolean exists(Long id) { return repo.existsById(id); }

    public UserQualificacao findByQualifAndUser(Long idQualif, Long idUser) {
        return repo.findUserQualificacaoByIdQualificacaoAndIdUser(idQualif, idUser);
    }
}