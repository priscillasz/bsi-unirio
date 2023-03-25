package net.codejava.userQualificacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQualificacaoRepository extends JpaRepository<UserQualificacao,Long> {

    public UserQualificacao findUserQualificacaoByIdQualificacaoAndIdUser(Long idQualif, Long idUser);

}