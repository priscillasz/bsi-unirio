package net.codejava.alocacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {

    public List<Alocacao> findAlocacaosByStatus(String status);

    public List<Alocacao> findAlocacaosByEdicaoSolicitada(String solicitada);

    public List<Alocacao> findAlocacaosByDesalocacaoSolicitada(String solicitada);
}
