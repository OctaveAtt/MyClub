package com.example.demo.dao;

import com.example.demo.model.User;




public interface UserDAO extends GenericDAO<Long,User> {

    User findByUsername(String username);
}
