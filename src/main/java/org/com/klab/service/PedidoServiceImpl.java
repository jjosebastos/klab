package org.com.klab.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.com.klab.model.Pedido;
import org.com.klab.model.PedidoProduto;
import org.com.klab.model.Produto;
import org.com.klab.repository.PedidoProdutoRepository;
import org.com.klab.repository.PedidoRepository;
import org.com.klab.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PedidoProdutoRepository pedidoProdutoRepository;

    @Transactional
    @Override
    public Pedido create(Pedido pedido, List<PedidoProduto> pedidoProdutoList) {
        if(pedido.getIdPedido() != null){
            return null;
        }
        if(pedidoProdutoList == null || pedidoProdutoList.isEmpty()){
            return null;
        }
        var pedidoSalvo = pedidoRepository.save(pedido);
        pedidoProdutoList.forEach(produto -> {
            produto.getPedido().setIdPedido(pedidoSalvo.getIdPedido());
            pedidoProdutoRepository.save(produto);
        });
        return pedidoSalvo;
    }

    @Override
    public Pedido update(Long id, Pedido pedido, List<PedidoProduto> pedidoProdutoList) {
        return null;
    }

    @Override
    public List<Pedido> getAll() {
        return pedidoRepository.findProdutosComPedidos();
    }

    @Override
    public void deleteById(Long id) {

    }
}
