package org.com.klab.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.com.klab.model.Produto;

import java.util.List;

@Getter
@Setter
public class ProdutoRequestDto {
    @JsonProperty("produtosList")
    private List<Produto> produtos;
}
