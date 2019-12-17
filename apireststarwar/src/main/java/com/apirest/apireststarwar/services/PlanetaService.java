package com.apirest.apireststarwar.services;

import java.util.List;
import java.util.Optional;

import com.apirest.apireststarwar.document.Planetas;

public interface PlanetaService {
	
	
	List<Planetas> listaTodos();
	
	Optional<Planetas> ListaPorId(String id);
		
	List<Planetas> getByNome(String nome);
	
	Planetas cadastrar(Planetas cliente);
	
	Planetas atualizar (Planetas cliente);
	
	void remover(String id);

}
