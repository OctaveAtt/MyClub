package com.example.demo.service;


import com.example.demo.impl.PlayerDAOImpl;
import com.example.demo.model.Contract;
import com.example.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IGenericService<Player,Long>{

    @Autowired
    PlayerDAOImpl dao;



    public void signNewDeal(Player data, Contract contract){
        dao.signNewDeal(data.getId(), contract);
    }
    @Override
    public void add(Player data) {
        dao.add(data);
    }

    @Override
    public void update(Player data) {
        dao.update(data);
    }

    @Override
    public void delete(Long aLong) {
        dao.deleteById(aLong);
    }

    @Override
    public List<Player> getAll() {
        return dao.getAll();
    }

    @Override
    public Player getById(Long aLong) {
        return dao.findById(aLong);
    }
}
