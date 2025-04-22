package org.com.klab.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    @NotBlank(message = "campo obrigatório")
    private String descricao;
    @Positive(message = "maior que zero")
    private Double preco;

    @JsonManagedReference("produto-pedidoproduto")
    @OneToMany(mappedBy = "produto",
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<PedidoProduto> pedidos;

    @JsonBackReference("departamento-pedidoproduto")
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

}
