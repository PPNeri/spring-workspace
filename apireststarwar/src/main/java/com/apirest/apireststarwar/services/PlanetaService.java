package com.apirest.apireststarwar.services;

import java.util.List;
import java.util.Optional;

import com.apirest.apireststarwar.document.Planetas;
//import com.apirest.apireststarwar.document.PlanetasApiSW;

public interface PlanetaService {
	
	//Lista todos os plnaetas do Banco
	List<Planetas> listaTodos();
	
	//Salva o planeta pesquisado na Api e retona a quantidade de apariçoes 
	Planetas criarPlaneta(Planetas planeta);
	
	//Lista os çPlanetas do banco por ID
	Optional<Planetas> ListaPorId(String id);
	
	//Lista os PLanetas do Banco por Nome
	List<Planetas> getByNome(String nome);
	
	//Cadastra um PLaneta novo no Banco passando nome , terreno 
	Planetas cadastrar(Planetas planeta);
	
	//Atualiza um  Planeta no Banco
	Planetas atualizar (Planetas planeta);
	
	//Remove o Planeta do banco
	void remover(String id);

}
