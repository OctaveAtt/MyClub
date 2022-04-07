package com.example.demo.web;

import com.example.demo.model.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DefaultModelAttributeController {

    @ModelAttribute("newPlayer")
    public Player getDefaultPlayer(){
        return new Player();
    }

    @ModelAttribute("newClub")
    public Club getDefaultClub(){
        return new Club();
    }

    @ModelAttribute("newContract")
    public Contract getDefaultContract(){
        return new Contract();
    }

    @ModelAttribute("newAgent")
    public Agent getDefaultAgent(){
        return new Agent();
    }

    @ModelAttribute("user")
    public User getDefaultUser(){
        return new User();
    }
}
