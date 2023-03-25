package net.codejava.conflito;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConflitoRepository extends JpaRepository<Conflito, Long> {
}
