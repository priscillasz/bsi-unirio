package net.codejava.alocacao;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Alocacao {
    private Long id;
    private Long idProjeto; // sugestao
    private Long idProfissional; // sugestao
    private Long idGerente; // projeto
    private String nomeProfissional; // sugestao
    private String nomeProjeto; // projeto
    private String nomeGerente; // projeto
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inicioAlocacao; // projeto necessidade
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fimAlocacao; // projeto necessidade
    private int cargaHoraria; // projeto necessidade
    private String status;
    private String tipoSolicitacao;
    private String desalocacaoSolicitada;
    private String edicaoSolicitada;
    private String statusEdicao;

    /* solicitação de edição de alocação */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date solicitacaoFimAlocacao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Long getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(Long idProfissional) {
        this.idProfissional = idProfissional;
    }

    public Long getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Long idGerente) {
        this.idGerente = idGerente;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    public Date getInicioAlocacao() {
        return inicioAlocacao;
    }

    public void setInicioAlocacao(Date inicioAlocacao) {
        this.inicioAlocacao = inicioAlocacao;
    }

    public Date getFimAlocacao() {
        return fimAlocacao;
    }

    public void setFimAlocacao(Date fimAlocacao) {
        this.fimAlocacao = fimAlocacao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(String tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }

    public String getDesalocacaoSolicitada() {
        return desalocacaoSolicitada;
    }

    public void setDesalocacaoSolicitada(String desalocacaoSolicitada) {
        this.desalocacaoSolicitada = desalocacaoSolicitada;
    }

    public Date getSolicitacaoFimAlocacao() {
        return solicitacaoFimAlocacao;
    }

    public void setSolicitacaoFimAlocacao(Date solicitacaoFimAlocacao) {
        this.solicitacaoFimAlocacao = solicitacaoFimAlocacao;
    }

    public String getEdicaoSolicitada() {
        return edicaoSolicitada;
    }

    public void setEdicaoSolicitada(String edicaoSolicitada) {
        this.edicaoSolicitada = edicaoSolicitada;
    }

    public String getStatusEdicao() {
        return statusEdicao;
    }

    public void setStatusEdicao(String statusEdicao) {
        this.statusEdicao = statusEdicao;
    }
}
