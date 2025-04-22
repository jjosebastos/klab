package org.com.klab.controller;

import lombok.AllArgsConstructor;
import org.com.klab.dto.request.ProdutoRequestDto;
import org.com.klab.model.Produto;
import org.com.klab.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<List<Produto>> create(@RequestBody ProdutoRequestDto input){
        if(input.getProdutos() == null){
            return ResponseEntity.badRequest().build();
        }
        try {
            var result = produtoService.save(input.getProdutos());
            return ResponseEntity.ok(result);
        } catch (Exception e){
          return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.ok((List<Produto>) this.produtoService.findAll());
    }

}
