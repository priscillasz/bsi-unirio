package net.codejava.qualificacao;


import net.codejava.qualificacao.Qualificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificacaoRepository extends JpaRepository<Qualificacao, Long> {

    public Qualificacao findQualificacaoByNomeAndNivel(String nome, String nivel);
}


