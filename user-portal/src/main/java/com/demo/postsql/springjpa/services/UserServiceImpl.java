package com.demo.postsql.springjpa.services;


import com.demo.postsql.springjpa.entity.User;
import com.demo.postsql.springjpa.repo.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

		@Autowired
	    private UserRepository repository;

	    @Override
	    public User create(User user) {
	        return repository.save(user);
	    }

	    @Override
	    public User delete(int id) {
	        Optional<User> user = findById(id);
	        User userFound = user.get();
	        if(user != null){
	            repository.delete(userFound);
	        }
	        return userFound;
	    }

	   
	    @Override
	    public Optional<User> findById(int id) {
	        return repository.findOne(id);
	    }

	    @Override
	    public User update(User user) {
	        return null;
	    }

		@Override
		public Iterable<User> findAll(Pageable pageable) {
			return repository.findAll(pageable).getContent();
		}
}
