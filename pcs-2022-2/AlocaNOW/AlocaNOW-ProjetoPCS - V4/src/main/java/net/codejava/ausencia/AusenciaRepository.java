package net.codejava.ausencia;

import net.codejava.ausencia.Ausencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AusenciaRepository extends JpaRepository<Ausencia, Long> {
    public List<Ausencia> findAusenciasByIdProfissional(Long idProfissional);
}
