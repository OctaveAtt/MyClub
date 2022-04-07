package com.example.demo.dao.jpa;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface IUserJPA extends JpaRepository<User,Long> {

    User findByUsername(String s);
}
