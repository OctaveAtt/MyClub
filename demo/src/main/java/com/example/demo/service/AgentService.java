package com.example.demo.service;

import com.example.demo.dao.AgentDAO;
import com.example.demo.dao.PlayerDAO;
import com.example.demo.impl.AgentDAOImpl;
import com.example.demo.model.Agent;
import com.example.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService implements IGenericService<Agent,Long>{

    @Autowired
    AgentDAOImpl dao;

    public void addClient(Player player, Agent data){
        dao.addPlayer(data,player);
    }

    @Override
    public void add(Agent data) {
        dao.add(data);
    }

    @Override
    public void update(Agent data) {
        dao.update(data);
    }

    @Override
    public void delete(Long aLong) {
        dao.deleteById(aLong);
    }

    @Override
    public List<Agent> getAll() {
        return dao.getAll();
    }

    @Override
    public Agent getById(Long aLong) {
        return dao.findById(aLong);
    }
}
