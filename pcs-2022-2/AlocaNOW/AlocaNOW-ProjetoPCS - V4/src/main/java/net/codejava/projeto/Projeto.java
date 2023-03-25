package net.codejava.projeto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Projeto {
    private Long id;
    private String nome;
    private String descricao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    /*@DateTimeFormat(pattern = "dd/MM/yyyy")*/
    private Date dataInicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    /*@DateTimeFormat(pattern = "dd/MM/yyyy")*/
    private Date dataFinal;
    private String nomeGerente;
    private Long idGerente;
    private String areaAtuacao;
    private String subAreaAtuacao;
    private String cep;

    // private int qtdProfissionais;

    /* getters e setters */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    public Long getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Long idGerente) {
        this.idGerente = idGerente;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getSubAreaAtuacao() {
        return subAreaAtuacao;
    }

    public void setSubAreaAtuacao(String subAreaAtuacao) {
        this.subAreaAtuacao = subAreaAtuacao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    /*  public int getQtdProfissionais() {
        return qtdProfissionais;
    }

    public void setQtdProfissionais(int qtdProfissionais) {
        this.qtdProfissionais = qtdProfissionais;
    }*/
}
