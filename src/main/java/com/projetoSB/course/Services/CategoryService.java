package com.projetoSB.course.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoSB.course.entites.Category;
import com.projetoSB.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired//injeta instância do category repository 
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}

