package org.com.klab.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.com.klab.model.PedidoProduto;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PedidoDto {
    @JsonProperty("idProduto")
    private Long id;
    @JsonProperty("dataPedido")
    private LocalDate dataPedido;
    @JsonProperty("pedidoProduto")
    private List<PedidoProduto> pedidoProdutoList;

}
