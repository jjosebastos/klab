package org.com.klab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class PedidoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedidoProduto;
    @Positive(message = "deve ser positivo")
    private int quantidade;
    @Positive(message = "deve ser positivo")
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}
