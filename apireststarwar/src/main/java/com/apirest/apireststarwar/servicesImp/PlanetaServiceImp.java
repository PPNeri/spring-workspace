package com.apirest.apireststarwar.servicesImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.apireststarwar.document.Planetas;
import com.apirest.apireststarwar.repository.PlanetaRepository;
import com.apirest.apireststarwar.services.PlanetaService;


@Service
public class PlanetaServiceImp implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository; 
		
	@Override
	public List<Planetas> listaTodos() {
		// TODO Auto-generated method stub
		return this.planetaRepository.findAll();
	}
/*
	@Override
	public Planetas listarPorId(String id) {
		// TODO Auto-generated method stub
		return planetaRepository.findById(id);
	}
*/
	@Override
	public Planetas cadastrar(Planetas cliente) {
		// TODO Auto-generated method stub
		return this.planetaRepository.save(cliente);
	}

	@Override
	public Planetas atualizar(Planetas cliente) {
		// TODO Auto-generated method stub
		return this.planetaRepository.save(cliente); 
	}

	@Override
	public void remover(String id) {
		
		this.planetaRepository.deleteById(id);
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<Planetas> getByNome(String nome) {
		// TODO Auto-generated method stub
		return planetaRepository.findByNomeContaining(nome);
	}
	
	@Override
	public Optional<Planetas> ListaPorId(String id) {
		// TODO Auto-generated method stub
		return planetaRepository.findById(id);
	}
	
}
