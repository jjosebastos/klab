package org.com.klab.repository;
import org.com.klab.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {


    @Query("SELECT p from produto p LEFT JOIN pedidoProduto v on p.idProduto = v.produto.idProduto where v.produto.idProduto is null ORDER BY p.descricao")
    List<Produto> findAllOrderByDescricao();


}
