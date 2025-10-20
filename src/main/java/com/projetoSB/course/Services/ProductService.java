package com.projetoSB.course.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoSB.course.entites.Product;
import com.projetoSB.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired//injeta instância do product repository
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}

