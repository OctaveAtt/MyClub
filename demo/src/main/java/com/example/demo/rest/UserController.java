package com.example.demo.rest;

import com.example.demo.model.Contract;
import com.example.demo.model.Player;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("UserRestCtrl")
@RequestMapping(UserController.URL)
public class UserController {

    public static final String URL= "/api/users";


    @Autowired
    UserService service;

    @PostMapping
    public void addUser(@RequestBody User user){
        service.add(user);
    }

    @GetMapping
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        service.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id")Long id){
        service.delete(id);
    }
}
