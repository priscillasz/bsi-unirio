package net.codejava.sugestao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {

    public Sugestao findSugestaoByNecessidadeId(Long idNecessidade);
}
