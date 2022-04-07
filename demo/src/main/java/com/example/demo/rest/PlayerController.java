package com.example.demo.rest;

import com.example.demo.dao.jpa.IPlayerJPA;
import com.example.demo.model.Club;
import com.example.demo.model.Contract;
import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController("playerRestCtrl")
@RequestMapping(PlayerController.URL)
public class PlayerController {
    public static final String URL = "/api/players";

    @Autowired
    PlayerService service;

    @Autowired
    IPlayerJPA jpa;

    @PostMapping
    public void addPlayer(@RequestBody Player player){
        service.add(player);
    }

    @GetMapping
    public List<Player> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @PutMapping
    public void updatePlayer(@RequestBody Player player){
        service.update(player);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable("id")Long id){
        service.delete(id);
    }

    @PostMapping("/signNewDeal/{playerId}")
    public String signNewDeal(@PathVariable("playerId") Long playerId, @ModelAttribute("newContract") Contract contract) throws IOException {
        service.signNewDeal(service.getById(playerId),contract);
        return "redirect:/players/{playerId}";
    }


    @PostMapping("/register")
    public String addPlayer(@Valid @ModelAttribute("newPlayer") Player player, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "players";
        }
        jpa.save(player);
        return "redirect:/players";
    }

}
