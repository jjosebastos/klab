package org.com.klab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    @NotBlank(message = "campo obrigatório")
    private String descricao;
    @Positive(message = "maior que zero")
    private Double preco;

}
