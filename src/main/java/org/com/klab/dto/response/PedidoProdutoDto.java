package org.com.klab.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PedidoProdutoDto {
    @JsonProperty("idPedidoProduto")
    private Long idPedidoProduto;
    @JsonProperty("quantidade")
    private Integer quantidade;
    @JsonProperty("produto")
    private ProdutoDto produto;
    @JsonProperty("total")
    private Double total;
}
