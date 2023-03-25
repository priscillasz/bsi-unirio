package net.codejava.projeto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    public Projeto findProjetoById(Long id);

    public Projeto findProjetoByNome(String nome);
}
