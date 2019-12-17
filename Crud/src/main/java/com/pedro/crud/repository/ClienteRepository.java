package com.pedro.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedro.crud.document.Planetas;

public interface ClienteRepository extends MongoRepository<Planetas, String> {

	
	
	

}
