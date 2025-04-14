package org.com.klab.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.com.klab.model.Pedido;
import org.com.klab.model.PedidoProduto;

import java.util.List;

@Getter
@Setter
public class PedidoRequestDto {
    @JsonProperty("pedido")
    private Pedido pedido;

    @JsonProperty("pedidoProduto")
    private List<PedidoProduto> pedidoProdutoList;
}
