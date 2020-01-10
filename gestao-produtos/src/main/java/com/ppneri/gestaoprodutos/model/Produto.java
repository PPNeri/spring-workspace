package com.ppneri.gestaoprodutos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tabela__De_Produtos")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String descricao;
	private Integer qtsEstoque;
	
	
	public Produto(Long id, String nome, String descricao, Integer qtsEstoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.qtsEstoque = qtsEstoque;
	}
	
	public Produto() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQtsEstoque() {
		return qtsEstoque;
	}
	public void setQtsEstoque(Integer qtsEstoque) {
		this.qtsEstoque = qtsEstoque;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
