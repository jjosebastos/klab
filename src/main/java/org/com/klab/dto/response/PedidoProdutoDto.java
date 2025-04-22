package org.com.klab.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.com.klab.model.PedidoProduto;


@Getter
@Setter
public class PedidoProdutoDto {

    @JsonProperty("pedido")
    private PedidoDto pedido;
    @JsonProperty("idPedidoProduto")
    private Long idPedidoProduto;
    @JsonProperty("quantidade")
    private Integer quantidade;
    @JsonProperty("produto")
    private ProdutoDto produto;
    @JsonProperty("total")
    private Double total;
}
