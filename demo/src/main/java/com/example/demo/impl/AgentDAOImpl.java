package com.example.demo.impl;


import com.example.demo.dao.AgentDAO;
import com.example.demo.dao.jpa.IAgentJPA;
import com.example.demo.dao.jpa.IPlayerJPA;
import com.example.demo.model.Agent;
import com.example.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class AgentDAOImpl implements AgentDAO {

    @Autowired
    IAgentJPA jpa;

    @Autowired
    IPlayerJPA playerJPA;

    @Override
    public void add(Agent agent) {
        jpa.save(agent);
    }


    public void addPlayer(Agent agent, Player player){
        playerJPA.save(player);
        agent.addClients(player);
    }

    @Override
    public Agent findById(Long aLong) {
        return jpa.getById(aLong);
    }

    @Override
    public Agent update(Agent agent) {
        return jpa.save(agent);
    }

    @Override
    public void deleteById(Long aLong) {
        jpa.deleteById(aLong);
    }

    @Override
    public List<Agent> getAll() {
        return jpa.findAll();
    }
}
