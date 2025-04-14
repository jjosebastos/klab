package org.com.klab.repository;
import org.com.klab.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    @Query("SELECT p FROM Produto p WHERE p.idProduto=:id")
    Produto findProdutoById(@Param("id") Long id);
}
