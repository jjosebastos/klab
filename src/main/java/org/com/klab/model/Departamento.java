package org.com.klab.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;
    @NotBlank(message = "descrição não pode ser vazia")
    private String descricao;
    @NotNull(message = "o id do produto não pode ser nulo")

    @JsonManagedReference("departamento-pedidoproduto")
    @OneToMany(mappedBy = "departamento")
    private List<Produto> produto;
}
