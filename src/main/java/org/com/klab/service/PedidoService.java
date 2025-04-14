package org.com.klab.service;

import org.com.klab.dto.response.PedidoProdutoDto;
import org.com.klab.model.Pedido;
import org.com.klab.model.PedidoProduto;

import java.util.List;

public interface PedidoService {
    public List<PedidoProdutoDto> create (Pedido pedido, List<PedidoProduto> pedidoProdutoList);
    public Pedido update (Long id, Pedido pedido, List<PedidoProduto> pedidoProdutoList);
    public Pedido findById(Long id);
    List<Pedido> getAll();

    void deleteById(Long id);
}
