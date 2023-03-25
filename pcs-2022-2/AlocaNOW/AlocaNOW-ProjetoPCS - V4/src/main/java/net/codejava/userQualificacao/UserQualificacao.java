package net.codejava.userQualificacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserQualificacao {
    private Long id;
    private Long idQualificacao;
    private Long idUser;
    private String nomeQualificacao;
    private String nivelQualificacao;
    private String usuario; // email

    public UserQualificacao() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdQualificacao() {
        return idQualificacao;
    }

    public void setIdQualificacao(Long idQualificacao) {
        this.idQualificacao = idQualificacao;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNomeQualificacao() {
        return nomeQualificacao;
    }

    public void setNomeQualificacao(String nomeQualificacao) {
        this.nomeQualificacao = nomeQualificacao;
    }

    public String getNivelQualificacao() {
        return nivelQualificacao;
    }

    public void setNivelQualificacao(String nivelQualificacao) {
        this.nivelQualificacao = nivelQualificacao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
