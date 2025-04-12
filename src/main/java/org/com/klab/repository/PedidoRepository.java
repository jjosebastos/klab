package org.com.klab.repository;

import org.com.klab.model.Pedido;
import org.com.klab.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p INNER JOIN PedidoProduto pp ON p.idPedido = pp.pedido.idPedido")
    List<Pedido> findProdutosComPedidos();
}
