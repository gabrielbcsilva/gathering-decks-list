package com.web.mtg.GatheringDecks.controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.web.mtg.GatheringDecks.models.Card;
import com.web.mtg.GatheringDecks.models.Deck;
import com.web.mtg.GatheringDecks.models.User;
import com.web.mtg.GatheringDecks.repositories.CardRepo;
import com.web.mtg.GatheringDecks.repositories.DeckRepo;
import com.web.mtg.GatheringDecks.repositories.UsersRepo;
import com.web.mtg.GatheringDecks.services.CookieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class DeckListController {
    @Autowired
    private DeckRepo repo;

    @Autowired
    private  UsersRepo repousu;




    @GetMapping("/decks")
    public String index(Model model,HttpServletRequest request) throws UnsupportedEncodingException{
        model.addAttribute("userName",CookieService.getCookie(request, "userName"));
        model.addAttribute("userId",CookieService.getCookie(request, "userId"));
        List<Deck> decks = (List<Deck>) repo.findAll();
        model.addAttribute("decks", decks);  
        
           
        return "deckList/index";
    }
 
    @GetMapping("/decks/novo")
    public String novo(Model model,HttpServletRequest request) throws UnsupportedEncodingException {
        model.addAttribute("userName",CookieService.getCookie(request, "userName"));
        model.addAttribute("userId",CookieService.getCookie(request, "userId"));
        return "deckList/novo";
    }

    @PostMapping("/deck/create")
    public String create(Deck deck,HttpServletRequest request) throws NumberFormatException, UnsupportedEncodingException {
        Optional<User> user = repousu.findById(Integer.valueOf(CookieService.getCookie(request, "userId")));
        deck.setUser(user.get());
        repo.save(deck);
        return "redirect:/decks";
    }

    @GetMapping("/deck/{id}/delete")
    public String delete(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/decks";
    }

    @GetMapping("/decks/user/{id}")
    public String searchUserName(@PathVariable int id, Model model) {
        Optional<User> user = repousu.findById(id);
       
            // model.addAttribute("user", user.get());
            return user.get().getName();
       
    }

   
   
}
