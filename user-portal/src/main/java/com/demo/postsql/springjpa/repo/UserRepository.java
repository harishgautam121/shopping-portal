package com.demo.postsql.springjpa.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.postsql.springjpa.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>,JpaRepository<User, Long> {	
	 	 
		@Query("select u from User u where u.id= ?1")
		Optional<User> findOne(int id);	

}
