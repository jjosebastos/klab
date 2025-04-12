package org.com.klab.controller;

import lombok.AllArgsConstructor;
import org.com.klab.dto.PedidoDto;
import org.com.klab.model.Pedido;
import org.com.klab.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@AllArgsConstructor
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody PedidoDto input){
        if(input.getId() != null){
            return ResponseEntity.badRequest().build();
        }
        var pedido = new Pedido(null, input.getDataPedido(), input.getPedidoProdutoList());
        try {
            var pedidoSalvo = pedidoService.create(pedido, input.getPedidoProdutoList());
            return ResponseEntity.ok(pedidoSalvo);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping()
    public ResponseEntity<List<Pedido>> showAll(){
        return ResponseEntity.ok(pedidoService.getAll());

    }

}
