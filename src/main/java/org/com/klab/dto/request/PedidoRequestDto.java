package org.com.klab.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.com.klab.dto.response.PedidoDto;
import org.com.klab.dto.response.PedidoProdutoDto;
import org.com.klab.model.Pedido;
import org.com.klab.model.PedidoProduto;

import java.util.List;

@Getter
@Setter
public class PedidoRequestDto {
    @JsonProperty("pedido")
    private Pedido pedido;

    @JsonProperty("pedidoProdutosList")
    private List<PedidoProduto> pedidoProdutoList;
}
