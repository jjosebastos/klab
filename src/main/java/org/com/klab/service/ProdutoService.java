package org.com.klab.service;

import org.com.klab.model.Produto;

import java.util.List;

public interface ProdutoService{

    List<Produto> save(List<Produto> produtosList);
    Produto findProdutoById(Long id);
    Iterable<Produto> findAll();
}
