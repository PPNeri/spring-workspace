package com.apirest.apireststarwar.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
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

import com.apirest.apireststarwar.document.Planetas;
import com.apirest.apireststarwar.event.RecursoCriadoEvent;
import com.apirest.apireststarwar.repository.PlanetaRepository;
import com.apirest.apireststarwar.responses.Response;
import com.apirest.apireststarwar.services.PlanetaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;
	
	
	//@Autowired
	PlanetaRepository planetaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@PostMapping("/planetasApi")
	@ApiOperation(value="Retorna a quantidade de aparições do Planeta, Buscando pela API")
	
	public ResponseEntity<Planetas> savePlaneta(@Valid @RequestBody Planetas planeta, HttpServletResponse response) {

		Planetas planetaSalvo = planetaService.criarPlaneta(planeta);
		if (planetaSalvo != null) {
			publisher.publishEvent(new RecursoCriadoEvent(this, response, planeta.getId()));
			return ResponseEntity.status(HttpStatus.CREATED).body(planetaSalvo);
		} else {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}

	}
	
		
	@GetMapping("/planetas")
	@ApiOperation(value="Retorna uma lista de Planetas")
	public ResponseEntity<Response<List<Planetas>>>listarTodos(){
		return ResponseEntity.ok(new Response<List<Planetas>>(this.planetaService.listaTodos()));
	}
	
	
	
	@GetMapping(value="/planetas/{id}")
	public Optional<Planetas> ListaPorId(@PathVariable String id) {
		return planetaService.ListaPorId(id);
	}
	
	
	@GetMapping(value="/planetas/nome/{nome}")
	public List<Planetas> getByNome(@PathVariable String nome){
		return planetaService.getByNome(nome);
	}
	
	
	@PostMapping("/planetas")
	@ApiOperation(value="Cadastra Planetas")
	public ResponseEntity<Response<Planetas>>cadastrar(@Valid @RequestBody Planetas cliente,BindingResult result){
		if (result.hasErrors()) {
			List<String>erros=new ArrayList<String>();
			
			result.getAllErrors().forEach(erro ->erros.add(erro.getDefaultMessage()));
			 
			return ResponseEntity.badRequest().body(new Response<Planetas>(erros));
			
			
			
		}
		
		return ResponseEntity.ok(new Response<Planetas>(this.planetaService.cadastrar(cliente)));
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
		
		
		return ResponseEntity.ok(new Response<Planetas>(this.planetaService.atualizar(cliente)));
	}
	
	
 
	@DeleteMapping("/planetas/{id}")
	@ApiOperation(value="Deleta Planetas")
	public ResponseEntity <Response<Integer>>remover(@PathVariable(name="id")String id){
		this.planetaService.remover(id);
		return ResponseEntity.ok(new Response <Integer>(1));
				
				
	}
	
	
	
	
	
}
