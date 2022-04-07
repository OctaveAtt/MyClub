package com.example.demo.dao.jpa;

import com.example.demo.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface IContractJPA extends JpaRepository<Contract, Long> {

}
