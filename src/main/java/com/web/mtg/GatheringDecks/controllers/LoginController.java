package com.web.mtg.GatheringDecks.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.web.mtg.GatheringDecks.models.Administrator;
import com.web.mtg.GatheringDecks.repositories.AdministratorsRepo;
import com.web.mtg.GatheringDecks.services.CookieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private AdministratorsRepo repo;
   
   
    @GetMapping("/login")
    public String index(){
       
        return "login/index";
    }

    @PostMapping("/login")
    public String logar(Model model, Administrator p_adm,HttpServletResponse response ) throws IOException{
       Administrator adm = this.repo.login(p_adm.getEmail(), p_adm.getSenha());
       if(adm!=null){ 
        CookieService.setCookie(response,"userId",String.valueOf(adm.getId()),(60*60*24));   
        CookieService.setCookie(response,"userName",String.valueOf(adm.getNome()),(60*60*24));   
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
