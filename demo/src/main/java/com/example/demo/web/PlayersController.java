package com.example.demo.web;

import com.example.demo.model.Contract;
import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("playerWebCtrl")
@RequestMapping("/players")
@SessionAttributes({"players","player"})
public class PlayersController {

    @Autowired
    private PlayerService service;

    @GetMapping
    public String getAll(Model model){
        List<Player> players = service.getAll();
        model.addAttribute("players",players);
        return "players";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id")Long id,Model model){
        Player player = service.getById(id);
        model.addAttribute("player",player);
        return "playersDetails";
    }

    @PostMapping("/addContract/{idPlayer}")
    public String signNewContract(@PathVariable("idPlayer")Long idPlayer, @ModelAttribute("newContract") Contract contract){
        service.signNewDeal(service.getById(idPlayer),contract);
        return "forward:/players/{idPlayer}";
    }



}
