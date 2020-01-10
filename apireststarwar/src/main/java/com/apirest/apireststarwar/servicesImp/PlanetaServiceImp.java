
package com.apirest.apireststarwar.servicesImp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apirest.apireststarwar.document.Planetas;
import com.apirest.apireststarwar.repository.PlanetaRepository;
import com.apirest.apireststarwar.services.PlanetaService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class PlanetaServiceImp implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository; 
	
	
	private static final String SWAPI_URL = "https://swapi.co/api/planets/?search=";
		
	
	
	
	
	@Override
	public Planetas criarPlaneta(Planetas planeta) {
		Integer qtd = this.obterQtdAparicoes(planeta.getNome());

		if (qtd == null) {
			return null;
		}

		planeta.setQuantidadeAparicoes(qtd);
		return planetaRepository.save(planeta);
	}
	
	
	
	
	@Override
	public List<Planetas> listaTodos() {
		// TODO Auto-generated method stub
		return this.planetaRepository.findAll();
	}

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

	
	private Integer obterQtdAparicoes(String name) {
		StringBuilder completeUrl = new StringBuilder();
		completeUrl.append(SWAPI_URL).append(name);

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		Object object;
		try {
			object = restTemplate.exchange(completeUrl.toString(), HttpMethod.GET,
					new HttpEntity<String>("parameters", headers), Object.class);
		} catch (Exception e) {
			return null;
		}

		Gson gson = new Gson();
		JsonArray results = gson.fromJson(gson.toJson(object), JsonObject.class).getAsJsonObject("body")
				.getAsJsonArray("results");

		JsonElement correctResult = null;

		for (JsonElement e : results) {
			if (e.getAsJsonObject().get("name").getAsString().equalsIgnoreCase(name)) {
				correctResult = e;
			}
		}

		if (correctResult == null) {
			return 0;
		} else {
			return correctResult.getAsJsonObject().getAsJsonArray("films").size();
		}
	}

	
	
}
