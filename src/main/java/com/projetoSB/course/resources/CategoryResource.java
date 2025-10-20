package com.projetoSB.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSB.course.Services.CategoryService;
import com.projetoSB.course.entites.Category;

@RestController //indica que a classe é um controlador rest, retorna json
@RequestMapping(value = "/categories")//define o caminho
public class CategoryResource {

	@Autowired//injeta instância do category repository
	private CategoryService service;
	
	@GetMapping//Diz que o metodo responde a requisições http get
	public ResponseEntity<List<Category>> findAll() {//ResponseEntity para uma resposta http completa
		List<Category> list = service.findAll(); 
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")//define o caminho(valor que vem na url) 
	public ResponseEntity<Category> findById(@PathVariable Long id){//pathVariable para dizer que o valor do id vem da url
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
