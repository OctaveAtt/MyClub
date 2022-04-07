package com.example.demo.web;


import com.example.demo.dao.jpa.IClubJPA;
import com.example.demo.model.Club;
import com.example.demo.model.Player;
import com.example.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller("clubWebCtrl")
@RequestMapping("/clubs")
public class ClubController {


    @Autowired
    private IClubJPA jpa;
    @Autowired
    private ClubService service;

    @GetMapping
    public String getAll(Model model){
        List<Club> clubs = service.getAll();
        model.addAttribute("clubs",clubs);
        return "clubs";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id")Long id,Model model){
        Club club =service.getById(id);
        model.addAttribute("club",club);
        model.addAttribute("players",club.getPlayers());
        return "clubsDetails";
    }



    @PostMapping("/addPlayer/{clubId}")
    public String addPlayer(@PathVariable("clubId") Long clubId, @ModelAttribute("newPlayer") Player player) throws IOException {
        service.addPlayer(service.getById(clubId), player);
        return "redirect:/clubs/{clubId}";
    }

    @PostMapping("/register")
    public String addClub(@Valid @ModelAttribute("newClub") Club club, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "clubs";
        }
        jpa.save(club);
        return "redirect:/clubs";
    }

}
