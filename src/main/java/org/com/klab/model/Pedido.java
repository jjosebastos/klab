package org.com.klab.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table
@Entity(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    private LocalDate dataPedido;

    public Pedido() {}

    public Pedido(Long idPedido, LocalDate dataPedido) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", dataPedido=" + dataPedido +
                '}';
    }
}
