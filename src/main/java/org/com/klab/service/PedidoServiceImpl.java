package org.com.klab.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.com.klab.dto.PedidoProdutoResumoDto;
import org.com.klab.dto.request.PedidoRequest;
import org.com.klab.dto.response.PedidoDto;
import org.com.klab.dto.response.PedidoProdutoDto;
import org.com.klab.dto.response.ProdutoDto;
import org.com.klab.model.Pedido;
import org.com.klab.model.PedidoProduto;

import org.com.klab.model.Produto;
import org.com.klab.repository.PedidoProdutoRepository;
import org.com.klab.repository.PedidoRepository;
import org.com.klab.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private Logger log = LoggerFactory.getLogger(PedidoServiceImpl.class);

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PedidoProdutoRepository pedidoProdutoRepository;
    @Autowired
    private ProdutoService produtoService;


    @Transactional
    @Override
    public List<PedidoProdutoDto> create(Pedido pedido, List<PedidoProduto> pedidoProdutoList) {
        if (pedido.getIdPedido() != null || pedidoProdutoList == null || pedidoProdutoList.isEmpty()) {
            return Collections.emptyList();
        }

        List<PedidoProdutoDto> result = new ArrayList<>();
        var pedidoSalvo = pedidoRepository.save(pedido);

        for (PedidoProduto pp : pedidoProdutoList) {
            var produtoId = pp.getProduto().getIdProduto();
            var produtoFound = produtoService.findProdutoById(produtoId);

            pp.setPedido(pedidoSalvo);
            pp.setProduto(produtoFound); // use o produto gerenciado
            pp.setPrecoProduto(produtoFound.getPreco());

            PedidoProduto salvo = pedidoProdutoRepository.save(pp);
            result.add(mapToDto(salvo));
        }

        return result;
    }

    @Transactional
    @Override
    public PedidoProdutoDto update(Long id, List<PedidoProdutoDto> pedido) {
        if(id == null || Objects.isNull(pedido)){
            return null;
        }
        var uPedido = pedidoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        uPedido.setDataPedido(pedido.get(0).getPedido().getDataPedido());
        var pedidoSalvo = pedidoRepository.save(uPedido);

        for (PedidoProdutoDto pp : pedido.stream().toList()){
            var produtoFound = this.produtoService.findProdutoById(pp.getProduto().getIdProduto());
            pp.set;
        }

        return null;
    }

    @Override
    public List<PedidoProdutoResumoDto> findByDataPedido(LocalDate dataInicial, LocalDate dataFinal) {
        return this.pedidoRepository.findPedidosProdutoByDataPedido(dataInicial, dataFinal);
    }

    @Override
    public void deleteById(Long id) {
        this.pedidoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        try {
            pedidoRepository.deleteById(id);
            pedidoProdutoRepository.deleteById(id);
        } catch (Exception e){
            log.error("Erro ao excluir pedido", e);
            throw e;
        }

    }

    @Override
    public Optional<PedidoProdutoResumoDto> findById(Long id) {
        return this.pedidoRepository.findByIdJoin(id);
    }

    private PedidoProdutoDto mapToDto(PedidoProduto pp) {
        PedidoProdutoDto dto = new PedidoProdutoDto();
        dto.setIdPedidoProduto(pp.getIdPedidoProduto());
        dto.setQuantidade(pp.getQuantidade());
        dto.setTotal(pp.getPrecoProduto() * pp.getQuantidade());

        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setIdPedido(pp.getPedido().getIdPedido());
        pedidoDto.setDataPedido(pp.getPedido().getDataPedido());
        dto.setPedido(pedidoDto);

        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setIdProduto(pp.getProduto().getIdProduto());
        produtoDto.setNome(pp.getProduto().getDescricao());
        produtoDto.setPreco(pp.getProduto().getPreco());
        dto.setProduto(produtoDto);

        return dto;
    }
}
