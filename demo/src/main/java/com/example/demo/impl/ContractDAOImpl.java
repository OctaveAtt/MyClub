package com.example.demo.impl;


import com.example.demo.dao.ContractDAO;
import com.example.demo.dao.jpa.IContractJPA;
import com.example.demo.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ContractDAOImpl implements ContractDAO {

    @Autowired
    IContractJPA jpa;

    @Override
    public void add(Contract contract) {
        jpa.save(contract);
    }

    @Override
    public Contract findById(Long aLong) {
        return jpa.getById(aLong);
    }

    @Override
    public Contract update(Contract contract) {
        return jpa.save(contract);
    }

    @Override
    public void deleteById(Long aLong) {
        jpa.deleteById(aLong);
    }

    @Override
    public List<Contract> getAll() {
        return jpa.findAll();
    }
}
