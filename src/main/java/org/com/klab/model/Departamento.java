package org.com.klab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Table
@Entity
@Data
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;
    @NotBlank(message = "descrição não pode ser vazia")
    private String descricao;
    @NotNull(message = "o id do produto não pode ser nulo")
    private Long idProduto;

}
