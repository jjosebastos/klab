package org.com.klab.model;

import jakarta.persistence.*;

@Table
@Entity(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;
    private String descricao;
    private Long idProduto;

    public Departamento() {}

    public Departamento(Long idDepartamento, String descricao, Long idProduto) {
        this.idDepartamento = idDepartamento;
        this.descricao = descricao;
        this.idProduto = idProduto;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "idDepartamento=" + idDepartamento +
                ", descricao='" + descricao + '\'' +
                ", idProduto=" + idProduto +
                '}';
    }
}
