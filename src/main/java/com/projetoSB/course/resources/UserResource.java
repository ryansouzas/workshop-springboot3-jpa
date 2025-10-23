package com.projetoSB.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetoSB.course.Services.UserService;
import com.projetoSB.course.entites.User;

@RestController //indica que a classe é um controlador rest, retorna json
@RequestMapping(value = "/users")//define o caminho
public class UserResource {

	@Autowired//injeta instância do user repository
	private UserService service;
	
	@GetMapping//Diz que o metodo responde a requisições http get
	public ResponseEntity<List<User>> findAll() {//ResponseEntity para uma resposta http completa
		List<User> list = service.findAll(); 
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")//define o caminho(valor que vem na url) 
	public ResponseEntity<User> findById(@PathVariable Long id){//pathVariable para dizer que o valor do id vem da url
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	
	@PostMapping //metodo que insere um novo recurso, recebe um metodo post do http
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
