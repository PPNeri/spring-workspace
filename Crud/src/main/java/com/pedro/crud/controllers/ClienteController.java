package com.pedro.crud.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.crud.document.Planetas;
import com.pedro.crud.responses.Response;
import com.pedro.crud.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	
	
	@GetMapping("/planetas")
	@ApiOperation(value="Retorna uma lista de Planetas")
	public ResponseEntity<Response<List<Planetas>>>listarTodos(){
		return ResponseEntity.ok(new Response<List<Planetas>>(this.clienteService.listaTodos()));
	}
	
	/*
	@GetMapping	(path="/{id}")
	public ResponseEntity<Response<Cliente>>listarPorId(@PathVariable(name="id")String id){
		return ResponseEntity.ok(new Response<Cliente>(this.clienteService.listarPorId(id)));
	}
	*/
	
	@PostMapping("/planetas")
	@ApiOperation(value="Cadastra Planetas")
	public ResponseEntity<Response<Planetas>>cadastrar(@Valid @RequestBody Planetas cliente,BindingResult result){
		if (result.hasErrors()) {
			List<String>erros=new ArrayList<String>();
			
			result.getAllErrors().forEach(erro ->erros.add(erro.getDefaultMessage()));
			 
			return ResponseEntity.badRequest().body(new Response<Planetas>(erros));
			
			
			
		}
		
		return ResponseEntity.ok(new Response<Planetas>(this.clienteService.cadastrar(cliente)));
	}
	
	
	@PutMapping("/planetas/{id}")
	@ApiOperation(value="Atualiza Planetas")
	public ResponseEntity<Response<Planetas>>atualizar (@PathVariable(name="id")String id,@Valid @RequestBody Planetas cliente,BindingResult result ){
		if (result.hasErrors()) {
			List<String>erros=new ArrayList<String>();
			
			result.getAllErrors().forEach(erro ->erros.add(erro.getDefaultMessage()));
			 
			return ResponseEntity.badRequest().body(new Response<Planetas>(erros));
			
			
			
		}
		
		
		cliente.setId(id);
		
		
		return ResponseEntity.ok(new Response<Planetas>(this.clienteService.atualizar(cliente)));
	}
	
	
 
	@DeleteMapping("/planetas/{id}")
	@ApiOperation(value="Deleta Planetas")
	public ResponseEntity <Response<Integer>>remover(@PathVariable(name="id")String id){
		this.clienteService.remover(id);
		return ResponseEntity.ok(new Response <Integer>(1));
				
				
	}
	
	
	
	
	
	

	
	
	
	
	
}
