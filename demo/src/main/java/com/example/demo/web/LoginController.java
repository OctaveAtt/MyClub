package com.example.demo.web;

import com.example.demo.dao.jpa.IUserJPA;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private IUserJPA jpa;

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user,HttpSession session){
        User dataUser = jpa.findByUsername(user.getUsername());
        System.out.println("------>"+user.getUsername()+user.getPassword());
        if(dataUser != null && dataUser.verifyPassword(user)){
            return "index";
        }
        session.invalidate();
        return "error";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model){

        model.addAttribute("user",null);
        session.invalidate();
        return "clubs";
    }
}
