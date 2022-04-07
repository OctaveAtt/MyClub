package com.example.demo.web;

import com.example.demo.dao.jpa.IAgentJPA;
import com.example.demo.model.Agent;
import com.example.demo.model.Club;
import com.example.demo.model.Player;
import com.example.demo.service.AgentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller("agentWebCtrl")
@RequestMapping("/agents")
public class AgentController {


    @Autowired
    private IAgentJPA jpa;
    @Autowired
    private AgentService service;

    @GetMapping
    public String getAll(Model model) {
        List<Agent> agents = service.getAll();
        model.addAttribute("agents", agents);
        return "agents";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        Agent agent = service.getById(id);
        model.addAttribute("agent", agent);
        return "agentDetails";
    }

    @PostMapping("/addPlayer/{agentId}")
    public String addClient(@PathVariable("agentId") Long clubId, @ModelAttribute("newPlayer") Player player) throws IOException {
        service.addClient(player, service.getById(clubId));
        return "forward:/agents/{agentId}";
    }

    @PostMapping("/register")
    public String addAgent(@Valid @ModelAttribute("newClub") Agent agent, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "agents";
        }
        jpa.save(agent);
        return "forward:/agents";
    }


}
