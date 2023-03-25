package net.codejava.sugestao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sugestao {
    private Long id;
    private Long projetoId;
    private Long profissionalId;
    private Long necessidadeId;
    private String nomeProfissional;
    private boolean solicitado;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(Long projetoId) {
        this.projetoId = projetoId;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public Long getNecessidadeId() {
        return necessidadeId;
    }

    public void setNecessidadeId(Long necessidadeId) {
        this.necessidadeId = necessidadeId;
    }

    public boolean isSolicitado() {
        return solicitado;
    }

    public void setSolicitado(boolean solicitado) {
        this.solicitado = solicitado;
    }
}
