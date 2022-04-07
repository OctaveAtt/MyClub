package com.example.demo.impl;

import com.example.demo.dao.UserDAO;
import com.example.demo.dao.jpa.IUserJPA;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {


    @Autowired
    IUserJPA jpa;

    @Override
    public void add(User user) {
        jpa.save(user);
    }

    @Override
    public User findById(Long aLong) {
        return jpa.getById(aLong);
    }

    @Override
    public User update(User user) {
        return jpa.save(user);
    }

    @Override
    public void deleteById(Long aLong) {
        jpa.deleteById(aLong);
    }

    @Override
    public List<User> getAll() {
        return jpa.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return jpa.findByUsername(username);
    }
}
