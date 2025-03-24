package org.com.klab.model;

import jakarta.persistence.*;

@Table
@Entity(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    private String descricao;
    private Double preco;

    public Produto() {}

    public Produto(Long idProduto, String descricao, Double preco) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "idProduto=" + idProduto +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
