package com.example.demo.dao.jpa;

import com.example.demo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface IPlayerJPA extends JpaRepository<Player, Long> {

}
