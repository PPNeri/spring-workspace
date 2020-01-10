
package com.apirest.apireststarwar.document;

import javax.validation.constraints.NotNull;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planetas")
public class Planetas {

	@Id
	private String id;

	@Indexed(unique = true)
	
	@NotNull
	private String nome;

	
	private String clima;

	
	private String terreno;

	
	private Integer quantidadeAparicoes;

	
	
	public Planetas(String id, String nome, String clima, String terreno, Integer quantidadeAparicoes) {
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.quantidadeAparicoes = quantidadeAparicoes;
	}

	public Planetas() {

	}

	@Override
	public String toString() {
		return "Planeta [id=" + id + ", nome=" + nome + ", clima=" + clima + ", terreno=" + terreno
				+ ", quantidadeAparicoes=" + quantidadeAparicoes + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getQuantidadeAparicoes() {
		return quantidadeAparicoes;
	}

	public void setQuantidadeAparicoes(Integer quantidadeAparicoes) {
		this.quantidadeAparicoes = quantidadeAparicoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planetas other = (Planetas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}

