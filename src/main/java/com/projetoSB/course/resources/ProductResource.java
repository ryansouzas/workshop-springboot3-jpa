package com.projetoSB.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSB.course.Services.ProductService;
import com.projetoSB.course.entites.Product;

@RestController //indica que a classe é um controlador rest, retorna json
@RequestMapping(value = "/products")//define o caminho
public class ProductResource {

	@Autowired//injeta instância do product repository
	private ProductService service;
	
	@GetMapping//Diz que o metodo responde a requisições http get
	public ResponseEntity<List<Product>> findAll() {//ResponseEntity para uma resposta http completa
		List<Product> list = service.findAll(); 
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")//define o caminho(valor que vem na url) 
	public ResponseEntity<Product> findById(@PathVariable Long id){//pathVariable para dizer que o valor do id vem da url
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
