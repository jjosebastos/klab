package org.com.klab.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PedidoDto {
    @JsonProperty("idProduto")
    private Long id;
    @JsonProperty("dataPedido")
    private LocalDate dataPedido;
}
