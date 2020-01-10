package com.ppneri.gestaoprodutos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ppneri.gestaoprodutos.model.Produto;
import com.ppneri.gestaoprodutos.repository.ProdutosRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {


	
	@Autowired
	private ProdutosRepository pr;
	
	
@GetMapping
public ModelAndView listarProdutos(Produto produto) {
	ModelAndView mv=new ModelAndView("index");
	mv.addObject("pr",pr.findAll());
	return mv;
	
}

@PostMapping
public String CadastrarProduto(Produto produto) {
	this.pr.save(produto);
	return ("redirect:/produtos");
}

	
	
	
	
	
	
	
	
	

}
