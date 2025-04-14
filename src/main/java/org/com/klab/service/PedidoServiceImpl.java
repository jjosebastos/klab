package org.com.klab.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.com.klab.dto.response.PedidoDto;
import org.com.klab.dto.response.PedidoProdutoDto;
import org.com.klab.dto.response.ProdutoDto;
import org.com.klab.model.Pedido;
import org.com.klab.model.PedidoProduto;

import org.com.klab.repository.PedidoProdutoRepository;
import org.com.klab.repository.PedidoRepository;
import org.com.klab.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@RequestMapping
public class PedidoServiceImpl implements PedidoService {



    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PedidoProdutoRepository pedidoProdutoRepository;
    @Autowired
    private ProdutoService produtoService;

    @Transactional
    @Override
    public List<PedidoProdutoDto> create(Pedido pedido, List<PedidoProduto> pedidoProdutoList) {
        if(pedido.getIdPedido() != null || pedidoProdutoList == null || pedidoProdutoList.isEmpty()) {
            return null;
        }
        List<PedidoProdutoDto> result = new ArrayList<>();
        var pedidoSalvo = pedidoRepository.save(pedido);
        for (PedidoProduto pp : pedidoProdutoList) {
            pp.setPedido(pedidoSalvo);

            var produtoId = pp.getProduto().getIdProduto();
            var produtoFound = produtoService.findProdutoById(produtoId);

            pp.setPrecoProduto(produtoFound.getPreco());
            pp.getProduto().setDescricao(produtoFound.getDescricao());
            pp.getProduto().setPreco(produtoFound.getPreco());

            PedidoProduto salvo = pedidoProdutoRepository.save(pp);
            result.add(mapToDto(salvo));

        }
        return result;
    }

    @Override
    public Pedido update(Long id, Pedido pedido, List<PedidoProduto> pedidoProdutoList) {
        return null;
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findPedidoById(id);
    }

    @Override
    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }



    @Override
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    private PedidoProdutoDto mapToDto(PedidoProduto pp) {
        PedidoProdutoDto dto = new PedidoProdutoDto();
        dto.setIdPedidoProduto(pp.getIdPedidoProduto());
        dto.setQuantidade(pp.getQuantidade());
        dto.setTotal(pp.getPrecoProduto() * pp.getQuantidade());

        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setIdProduto(pp.getProduto().getIdProduto());
        produtoDto.setNome(pp.getProduto().getDescricao());
        produtoDto.setPreco(pp.getProduto().getPreco());

        dto.setProduto(produtoDto);

        return dto;
    }
}
