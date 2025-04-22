package org.com.klab.repository;

import org.com.klab.model.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long> {

    Optional<PedidoProduto> findById(Long id);
}
