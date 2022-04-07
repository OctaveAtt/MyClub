package com.example.demo.impl;


import com.example.demo.dao.PlayerDAO;
import com.example.demo.dao.jpa.IContractJPA;
import com.example.demo.dao.jpa.IPlayerJPA;
import com.example.demo.model.Contract;
import com.example.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PlayerDAOImpl implements PlayerDAO {

    @Autowired
    IPlayerJPA jpa;

    @Autowired
    IContractJPA iContractJPA;

    @Override
    public void add(Player player) {
        jpa.save(player);
    }

    @Override
    public Player findById(Long aLong) {
        return jpa.getById(aLong);
    }

    @Override
    public Player update(Player player) {
        return jpa.save(player);
    }

    @Override
    public void deleteById(Long aLong) {
        jpa.deleteById(aLong);
    }

    @Override
    public List<Player> getAll() {
        return jpa.findAll();
    }


    @Override
    public void signNewDeal(Long aLong, Contract contract) {
        Player player = findById(aLong);
        player.setContract(contract);
        iContractJPA.save(contract);
        jpa.save(player);
    }
}
