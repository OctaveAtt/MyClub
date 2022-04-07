package com.example.demo.impl;


import com.example.demo.dao.ClubDAO;
import com.example.demo.dao.jpa.IClubJPA;
import com.example.demo.dao.jpa.IPlayerJPA;
import com.example.demo.model.Club;
import com.example.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClubDAOImpl implements ClubDAO {

    @Autowired
    IClubJPA jpa;

    @Autowired
    IPlayerJPA iPlayerJPA;

    @Override
    public void add(Club club) {
        jpa.save(club);
    }

    @Override
    public void addPlayer(Club club, Player player){

        player.setClub(club);
        iPlayerJPA.save(player);
        club.addPlayers(player);
        update(club);
    }

    @Override
    public Club findById(Long aLong) {
        return jpa.getById(aLong);
    }

    @Override
    public Club update(Club club) {
        return jpa.save(club);
    }

    @Override
    public void deleteById(Long aLong) {
        jpa.deleteById(aLong);
    }

    @Override
    public List<Club> getAll() {
        return jpa.findAll();
    }
}
