package com.projetoSB.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoSB.course.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	
}
