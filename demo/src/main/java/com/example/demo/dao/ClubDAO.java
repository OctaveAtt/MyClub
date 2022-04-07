package com.example.demo.dao;

import com.example.demo.model.Club;
import com.example.demo.model.Player;

public interface ClubDAO extends GenericDAO<Long, Club>{

    void addPlayer(Club club, Player player);
}
