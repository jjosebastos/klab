package org.com.klab.model;

import jakarta.persistence.*;

@Entity(name = "pedidoProduto")
public class PedidoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedidoProduto;

    @ManyToOne
    @JoinColumn(name = "idProduto", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    private Pedido pedido;
    private int quantidade;
    private Double valor;

    public PedidoProduto() {}

    public PedidoProduto(Long idPedidoProduto, Produto produto, Pedido pedido, int quantidade, Double valor) {
        this.idPedidoProduto = idPedidoProduto;
        this.produto = produto;
        this.pedido = pedido;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Long getIdPedidoProduto() {
        return idPedidoProduto;
    }

    public void setIdPedidoProduto(Long idPedidoProduto) {
        this.idPedidoProduto = idPedidoProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    @Override
    public String toString() {
        return "PedidoProduto{" +
                "idPedidoProduto=" + idPedidoProduto +
                ", produto=" + produto +
                ", pedido=" + pedido +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }
}
