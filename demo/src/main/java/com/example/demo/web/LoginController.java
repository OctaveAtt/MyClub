package com.example.demo.web;

import com.example.demo.dao.jpa.IUserJPA;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private IUserJPA jpa;

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user){
        User dataUser = jpa.findByUsername(user.getUsername());
        if(dataUser != null && dataUser.verifyPassword(user)){
            return "index";
        }
        return "error";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "forward:/clubs";
    }
}
