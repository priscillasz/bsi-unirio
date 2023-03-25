package net.codejava.projeto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ProjetoNecessidade {
    private Long id;
    private Long idProjeto;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataInicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataFim;
    private int horaDia;
    private String cargo;
    private Long idQualificacao1;
    private Long idQualificacao2;
    private Long idQualificacao3;
    private String areaProjeto;
    private String subAreaProjeto;
    private String qualif1;
    private String qualif2;
    private String qualif3;

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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getHoraDia() {
        return horaDia;
    }

    public void setHoraDia(int horaDia) {
        this.horaDia = horaDia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getIdQualificacao1() {
        return idQualificacao1;
    }

    public void setIdQualificacao1(Long idQualificacao1) {
        this.idQualificacao1 = idQualificacao1;
    }

    public Long getIdQualificacao2() {
        return idQualificacao2;
    }

    public void setIdQualificacao2(Long idQualificacao2) {
        this.idQualificacao2 = idQualificacao2;
    }

    public Long getIdQualificacao3() {
        return idQualificacao3;
    }

    public void setIdQualificacao3(Long idQualificacao3) {
        this.idQualificacao3 = idQualificacao3;
    }

    public String getAreaProjeto() {
        return areaProjeto;
    }

    public void setAreaProjeto(String areaProjeto) {
        this.areaProjeto = areaProjeto;
    }

    public String getSubAreaProjeto() {
        return subAreaProjeto;
    }

    public void setSubAreaProjeto(String subAreaProjeto) {
        this.subAreaProjeto = subAreaProjeto;
    }

    public String getQualif1() {
        return qualif1;
    }

    public void setQualif1(String qualif1) {
        this.qualif1 = qualif1;
    }

    public String getQualif2() {
        return qualif2;
    }

    public void setQualif2(String qualif2) {
        this.qualif2 = qualif2;
    }

    public String getQualif3() {
        return qualif3;
    }

    public void setQualif3(String qualif3) {
        this.qualif3 = qualif3;
    }
}
