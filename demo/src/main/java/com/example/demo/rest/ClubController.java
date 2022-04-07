package com.example.demo.rest;

import com.example.demo.model.Club;
import com.example.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("clubRestCtrl")
@RequestMapping(ClubController.URL)
public class ClubController {
    public static final String URL = "/api/clubs";

    @Autowired
    ClubService service;


    @PostMapping
    public void addClub(@RequestBody Club club){
        service.add(club);
    }

    @GetMapping
    public List<Club> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Club getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @PutMapping
    public void updateClub(@RequestBody Club club){
        service.update(club);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable("id")Long id){
        service.delete(id);
    }


}
