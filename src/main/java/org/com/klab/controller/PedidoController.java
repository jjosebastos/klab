package org.com.klab.controller;

import jakarta.validation.Valid;
import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import org.com.klab.dto.PedidoProdutoRequestDto;
import org.com.klab.dto.PedidoProdutoResumoDto;
import org.com.klab.dto.request.PedidoProdutoUpdate;
import org.com.klab.dto.request.PedidoRequest;
import org.com.klab.dto.request.PedidoRequestDto;
import org.com.klab.dto.response.PedidoDto;
import org.com.klab.dto.response.PedidoProdutoDto;
import org.com.klab.model.Pedido;
import org.com.klab.model.PedidoProduto;
import org.com.klab.repository.PedidoRepository;
import org.com.klab.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private PedidoRepository pedidoRepository;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PedidoProdutoDto>> create(@RequestBody PedidoRequestDto input){
        if(input.getPedido().getIdPedido() != null){
            return ResponseEntity.badRequest().build();
        }
        var pedido = new Pedido(null, input.getPedido().getDataPedido(), null);
        try {
            var pedidoSalvo = pedidoService.create(pedido, input.getPedidoProdutoList());
            return ResponseEntity.ok(pedidoSalvo);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    @RequestMapping
    public ResponseEntity<List<PedidoProdutoResumoDto>> findAll(@RequestBody @Valid PedidoProdutoRequestDto input){
        if(input.getDataInicial() == null || input.getDataFinal() == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.pedidoService.findByDataPedido(input.getDataInicial(), input.getDataFinal()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<PedidoProdutoDto>> update(@PathVariable Long id, @RequestBody List<PedidoProdutoUpdate> input){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        var updatedPedidoProduto = this.pedidoService.update(id, input.get(0).getPedidoProdutoList());
        return ResponseEntity.ok(updatedPedidoProduto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            this.pedidoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PedidoProdutoResumoDto>> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.pedidoService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pedido>> findAll(){
        return ResponseEntity.ok(this.pedidoRepository.findAll());
    }




}
