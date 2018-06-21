package com.demo.postsql.springjpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.demo.postsql.springjpa.entity.User;
import com.demo.postsql.springjpa.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Api(tags = ("Activities"))
@RestController
@RequestMapping(path = "/users", produces = {"application/json"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping(path = {"/{id}"})
    public User findOne(@PathVariable("id") int id){
        return userService.findById(id).get();
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public User delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    @ApiOperation(value = "List Users", notes = "List all Users")
    @GetMapping("/list")
    public List<User> findAll(Pageable pageable){
        return (List<User>)userService.findAll(pageable);
    }
}
