package com.demo.postsql.springjpa.services;



import java.util.Optional;

import org.springframework.data.domain.Pageable;


import com.demo.postsql.springjpa.entity.User;

public interface UserService {

    User create(User user);

    User delete(int id);

    
    Iterable<User> findAll(Pageable pageable);

    Optional<User> findById(int id);

    User update(User user);
}
