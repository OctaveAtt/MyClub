package com.example.demo.rest;

import com.example.demo.model.Agent;
import com.example.demo.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("agentRestCtrl")
@RequestMapping(AgentController.URL)
public class AgentController {
    public static final String URL = "/api/agents";

    @Autowired
    AgentService service;


    @PostMapping
    public void addAgent(@RequestBody Agent agent){
        service.add(agent);
    }

    @GetMapping
    public List<Agent> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Agent getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @PutMapping
    public void updateAgent(@RequestBody Agent agent){
        service.update(agent);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable("id")Long id){
        service.delete(id);
    }


}
