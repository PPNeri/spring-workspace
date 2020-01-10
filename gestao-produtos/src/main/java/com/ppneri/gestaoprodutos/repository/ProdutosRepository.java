package com.ppneri.gestaoprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppneri.gestaoprodutos.model.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {
	
	
	

}
