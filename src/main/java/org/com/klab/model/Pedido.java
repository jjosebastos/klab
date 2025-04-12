package org.com.klab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    @PastOrPresent
    private LocalDate dataPedido;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoProduto> produtos;

}
