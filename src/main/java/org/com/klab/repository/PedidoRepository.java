package org.com.klab.repository;

import jakarta.websocket.server.PathParam;
import org.com.klab.model.Pedido;
import org.com.klab.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p INNER JOIN PedidoProduto pp ON p.idPedido = pp.pedido.idPedido")
    List<Pedido> findProdutosComPedidos();

    @Query(value = "SELECT p FROM Pedido p WHERE p.idPedido = :id")
    Pedido findPedidoById(@PathVariable Long id);
}
