package org.com.klab.repository;

import org.com.klab.dto.PedidoProdutoResumoDto;
import org.com.klab.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {


    @Query("SELECT p FROM Pedido p WHERE p.idPedido = :id")
    Pedido findPedidoById(@PathVariable Long id);

    @Query(value = """
    SELECT 
        p.id_pedido AS idPedido, 
        p.data_pedido AS dataPedido, 
        pr.descricao AS descricao,
        pp.produto_id AS idProduto,
        pp.quantidade as quantidade,
        SUM(pp.preco_produto * pp.quantidade) AS total
    FROM pedido p
    INNER JOIN pedido_produto pp ON p.id_pedido = pp.pedido_id
    INNER JOIN produto pr ON pp.produto_id = pr.id_produto
    WHERE p.data_pedido BETWEEN :dataInicial AND :dataFinal
    GROUP BY p.id_pedido, p.data_pedido, pr.descricao, pp.produto_id
    ORDER BY p.id_pedido, pp.produto_id
    """, nativeQuery = true)
    List<PedidoProdutoResumoDto> findPedidosProdutoByDataPedido(@Param("dataInicial") LocalDate dataInicial,
                                                @Param("dataFinal") LocalDate dataFinal);

    @Query(value = """
    SELECT 
        p.id_pedido AS idPedido,
        p.data_pedido as dataPedido,
        pr.descricao as descricao,
        pp.produto_id as idProduto,
        pp.quantidade as quantidade,
        (pp.preco_produto * pp.quantidade) AS total
    FROM pedido p 
    INNER JOIN pedido_produto pp ON p.id_pedido = pp.pedido_id
    INNER JOIN produto pr ON pp.produto_id = pr.id_produto
    WHERE p.id_pedido = :id
    """, nativeQuery = true)
    Optional<PedidoProdutoResumoDto> findByIdJoin(@Param("id") Long id);
}
