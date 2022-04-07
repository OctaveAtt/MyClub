package com.example.demo.service;

import com.example.demo.dao.ContractDAO;
import com.example.demo.dao.PlayerDAO;
import com.example.demo.impl.ContractDAOImpl;
import com.example.demo.model.Contract;
import com.example.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IGenericService<Contract,Long>{

    @Autowired
    ContractDAOImpl dao;

    @Override
    public void add(Contract data) {
        dao.add(data);
    }

    @Override
    public void update(Contract data) {
        dao.update(data);
    }

    @Override
    public void delete(Long aLong) {
        dao.deleteById(aLong);
    }

    @Override
    public List<Contract> getAll() {
        return dao.getAll();
    }

    @Override
    public Contract getById(Long aLong) {
        return dao.findById(aLong);
    }
}
