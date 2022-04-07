package com.example.demo.dao.jpa;

import com.example.demo.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgentJPA extends JpaRepository<Agent, Long> {
}
