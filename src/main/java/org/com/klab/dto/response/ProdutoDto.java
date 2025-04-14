package org.com.klab.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {

    @JsonProperty("idProduto")
    private Long idProduto;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("preco")
    private Double preco;
}
