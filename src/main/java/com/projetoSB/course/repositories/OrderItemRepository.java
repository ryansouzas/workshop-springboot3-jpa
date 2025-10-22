package com.projetoSB.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoSB.course.entites.OrderItem;
import com.projetoSB.course.entites.pk.OrderItemPK;

//nesse caso é opcional colocar a notação @repository pois ele já esta herdando do JpaRepository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {


	/*
	 Ao herdar jpa JPARepository<n,Long> (n: é a entidade que o repositório gerencia. Long:é o tipo do ID da entidade.)
	 Isso autmaticamente fornece metodos prontos, como:
	 
	 findAll()
	 
	 findById(Long id)
	 
	 save(User u)
	 
	 deleteById(Long id)
	 
	 count()*/
}
