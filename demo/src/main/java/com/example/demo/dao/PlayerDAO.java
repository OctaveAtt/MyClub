package com.example.demo.dao;

import com.example.demo.model.Contract;
import com.example.demo.model.Player;

public interface PlayerDAO extends GenericDAO<Long, Player>{

    void signNewDeal(Long aLong, Contract contract);
}
