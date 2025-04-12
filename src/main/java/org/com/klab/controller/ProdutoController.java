package org.com.klab.controller;

import org.com.klab.dto.PedidoDto;
import org.com.klab.dto.ProdutoDto;
import org.com.klab.model.Produto;
import org.com.klab.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;


    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody ProdutoDto input){
        if(input.getIdProduto() != null){
            return ResponseEntity.badRequest().build();
        }
        try {
            var saved = produtoRepository.
                    save(new Produto(null, input.getDescricao(),input.getPreco()));
            return ResponseEntity.ok(saved);
        } catch (Exception e){
          return ResponseEntity.internalServerError().build();
        }
    }



}
