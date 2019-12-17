package com.pedro.crud.services;

import java.util.List;

import com.pedro.crud.document.Planetas;

public interface ClienteService {
	
	
	List<Planetas> listaTodos();
		
	//Cliente listarPorId(String id);
	
	Planetas cadastrar(Planetas cliente);
	
	Planetas atualizar (Planetas cliente);
	
	void remover(String id);
	
	
	

}
