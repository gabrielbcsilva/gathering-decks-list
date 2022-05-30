package com.web.mtg.GatheringDecks.controllers;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import com.web.mtg.GatheringDecks.services.CookieService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model,HttpServletRequest request) throws UnsupportedEncodingException{
        model.addAttribute("userName",CookieService.getCookie(request, "userName"));
        return "home/index";
    }
}
