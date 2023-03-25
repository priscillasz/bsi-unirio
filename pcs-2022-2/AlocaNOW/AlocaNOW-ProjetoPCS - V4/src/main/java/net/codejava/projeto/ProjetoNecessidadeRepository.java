package net.codejava.projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public  interface ProjetoNecessidadeRepository extends JpaRepository<ProjetoNecessidade,Long> {
    /*@Query("Select p from ProjetoNecessidade p where p.projetoId = :projetoId")
    public List<ProjetoNecessidade> findByProjetoId(@Param("projetoId") Long projetoId);*/
}
