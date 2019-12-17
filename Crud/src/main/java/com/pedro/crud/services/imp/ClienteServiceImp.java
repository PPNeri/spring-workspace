package com.pedro.crud.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.crud.document.Planetas;
import com.pedro.crud.repository.ClienteRepository;
import com.pedro.crud.services.ClienteService;


@Service

public class ClienteServiceImp implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository; 
	
	
	@Override
	public List<Planetas> listaTodos() {
		// TODO Auto-generated method stub
		return this.clienteRepository.findAll();
	}
/*
	@Override
	public Object listarPorId(String id) {
		// TODO Auto-generated method stub
		return this.clienteRepository.findById(id);
	}
*/
	@Override
	public Planetas cadastrar(Planetas cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente);
	}

	@Override
	public Planetas atualizar(Planetas cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente); 
	}

	@Override
	public void remover(String id) {
		
		this.clienteRepository.deleteById(id);
		// TODO Auto-generated method stub

	}

}
