package com.projetoSB.course.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoSB.course.entites.Order;
import com.projetoSB.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired//injeta instância do order repository
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}

