package com.example.demo.service;

import com.example.demo.dao.ClubDAO;
import com.example.demo.impl.ClubDAOImpl;
import com.example.demo.model.Club;
import com.example.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService implements IGenericService<Club,Long>{

    @Autowired
    ClubDAO dao;

    public void addPlayer(Club club ,Player player){
        dao.addPlayer(club, player);
    }
    @Override
    public void add(Club data) {
        dao.add(data);
    }

    @Override
    public void update(Club data) {
        dao.update(data);
    }

    @Override
    public void delete(Long aLong) {
        dao.deleteById(aLong);
    }

    @Override
    public List<Club> getAll() {
        return dao.getAll();
    }

    @Override
    public Club getById(Long aLong) {
        return dao.findById(aLong);
    }
}
