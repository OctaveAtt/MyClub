package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.impl.UserDAOImpl;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IGenericService<User,Long> {

    @Autowired
    UserDAO dao;


    @Override
    public void add(User data) {
        dao.add(data);
    }

    @Override
    public void update(User data) {
        dao.update(data);
    }

    @Override
    public void delete(Long aLong) {
        dao.deleteById(aLong);
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public User getById(Long aLong) {
        return dao.findById(aLong);
    }


    public User getByUsername(String username){
        return dao.findByUsername(username);
    }
}
