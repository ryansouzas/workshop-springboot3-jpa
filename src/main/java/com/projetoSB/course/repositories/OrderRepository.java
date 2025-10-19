package com.projetoSB.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoSB.course.entites.Order;

//nesse caso é opcional colocar a notação @repository pois ele já esta herdando do JpaRepository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
