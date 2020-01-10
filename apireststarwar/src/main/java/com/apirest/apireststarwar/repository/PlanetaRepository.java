package com.apirest.apireststarwar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apirest.apireststarwar.document.Planetas;

public interface PlanetaRepository extends MongoRepository<Planetas, String> {
	
	List<Planetas> findByNomeContaining(String nome);


}
