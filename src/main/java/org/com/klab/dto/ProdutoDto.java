package org.com.klab.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {
    @JsonProperty("idProduto")
    private Long idProduto;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("preco")
    private Double preco;

}
