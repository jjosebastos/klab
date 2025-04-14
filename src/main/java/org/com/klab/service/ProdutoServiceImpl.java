package org.com.klab.service;

import lombok.AllArgsConstructor;
import org.com.klab.model.Produto;
import org.com.klab.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Override
    public List<Produto> save(List<Produto> produtosList) {
        if(produtosList.isEmpty()) {
            return null;
        }
        List<Produto> result = new ArrayList<>();
        for (Produto produto : produtosList) {
            if(produto.getIdProduto() == null) {
                produtoRepository.save(produto);
                produto.setIdProduto(produto.getIdProduto());
                result.add(produto);
            }
        }
        return result;

    }

    @Override
    public Produto findProdutoById(Long id) {
        return produtoRepository.findProdutoById(id);
    }


}
