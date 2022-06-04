package com.web.mtg.GatheringDecks.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.web.mtg.GatheringDecks.models.User;
import com.web.mtg.GatheringDecks.repositories.UsersRepo;
import com.web.mtg.GatheringDecks.services.CookieService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@ComponentScan(basePackages = {"com.web.mtg.GatheringDecks"})
@Controller
public class LoginController {
    @Autowired(required = true)
    private UsersRepo repo;
   
   
    @GetMapping("/login")
    public String index(){
       
        return "login/index";
    }

    @PostMapping("/login")
    public String singIn(Model model, User p_adm,HttpServletResponse response ) throws IOException{
       User adm = this.repo.login(p_adm.getEmail(), p_adm.getPassword());
       if(adm!=null){ 
        CookieService.setCookie(response,"userId",String.valueOf(adm.getId()),(60*60*24));   
        CookieService.setCookie(response,"userName",String.valueOf(adm.getName()),(60*60*24));   
        return "redirect:/";
    }
       model.addAttribute("error", "Usuário ou senha inválidos");
       return "login/index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) throws IOException{
        CookieService.setCookie(response,"userId","",0);
        return "redirect:/login";
    }
}
