package com.pedro.crud.document;




//import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planetas {

	@Id
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	
	
	public Planetas () {
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@NotEmpty(message="Nome não pode ser vazio ")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotEmpty(message="clima não pode ser vazio ")
	//@Email(message="email invalido")
	public String getclima() {
		return clima;
	}
	
	public void setEmail(String clima) {
		this.clima = clima;
	}
	@NotEmpty(message="Terreno não pode ser vazio ")
	//@CPF(message="cof invlido")
	public String getTerreno() {
		return terreno;
	}
	public void setCpf(String terreno) {
		this.terreno = terreno;
	}

	
	
	
	
	
	
}
