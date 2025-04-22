package org.com.klab.service;

import org.com.klab.dto.PedidoProdutoResumoDto;
import org.com.klab.dto.request.PedidoRequest;
import org.com.klab.dto.response.PedidoProdutoDto;
import org.com.klab.model.Pedido;
import org.com.klab.model.PedidoProduto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PedidoService {
    public List<PedidoProdutoDto> create (Pedido pedido, List<PedidoProduto> pedidoProdutoList);
    public PedidoProdutoDto update (Long id, List<PedidoProdutoDto> pedidoRequest);
    public List<PedidoProdutoResumoDto> findByDataPedido(LocalDate dataInicial, LocalDate dataFinal);
    void deleteById(Long id);
    Optional<PedidoProdutoResumoDto> findById(Long id);
}
