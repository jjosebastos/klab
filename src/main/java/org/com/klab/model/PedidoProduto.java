package org.com.klab.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Double precoProduto;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    @JsonBackReference
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    @JsonBackReference("produtoPedido")
    private Pedido pedido;

}
