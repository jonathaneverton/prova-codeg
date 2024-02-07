package com.example.codeg.model;

import com.example.codeg.dto.PersonDTO;
import com.example.codeg.dto.ProjectDTO;
import com.example.codeg.enums.RiskClassification;
import com.example.codeg.enums.StatusProject;
import org.hibernate.annotations.Columns;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projeto")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataInicio;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataPrevisaoFim;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataFim;
    private String descricao;
    private String status;
    private Double orcamento;
    private String risco;

    @Transient
    private RiskClassification riskClassification;

    @Transient
    private StatusProject statusProject;

    @ManyToOne
    @JoinColumn(name = "idgerente")
    private Person gerente;

    @OneToMany(mappedBy = "projeto")
    private List<Member> membros;

    public Project(ProjectDTO projectDTO) {
        this.nome = projectDTO.nome();
        this.dataInicio = projectDTO.datainicio();
        this.dataPrevisaoFim = projectDTO.dataPrevisaoFim();
        this.dataFim = projectDTO.dataFim();
        this.descricao = projectDTO.descricao();
        this.status = projectDTO.status();
        this.orcamento = projectDTO.orcament();
        this.risco = projectDTO.risco();
    }

    public Project() {

    }

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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public void setDataPrevisaoFim(LocalDate dataPrevisaoFim) {
        this.dataPrevisaoFim = dataPrevisaoFim;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public Person getGerente() {
        return gerente;
    }

    public void setGerente(Person gerente) {
        this.gerente = gerente;
    }

    public List<Member> getMembros() {
        return membros;
    }

    public void setMembros(List<Member> membros) {
        this.membros = membros;
    }

    public void setRiskClassification(RiskClassification riskClassification) {
        this.risco = riskClassification.name();
    }

    public RiskClassification getRiskClassification() {
        return riskClassification;
    }

    public void setStatusProject(StatusProject statusProject) {
        this.status = statusProject.name();
    }

    public StatusProject getStatusProject() {
        return statusProject;
    }

}
