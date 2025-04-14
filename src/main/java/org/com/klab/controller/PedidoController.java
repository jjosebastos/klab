package org.com.klab.controller;

import lombok.AllArgsConstructor;
import org.com.klab.dto.request.PedidoRequestDto;
import org.com.klab.dto.response.PedidoProdutoDto;
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


    @PostMapping(consumes = "application/json")

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

    @GetMapping("/all")
    public ResponseEntity<List<Pedido>> showAll(){
        return ResponseEntity.ok(pedidoService.getAll());

    }

}
