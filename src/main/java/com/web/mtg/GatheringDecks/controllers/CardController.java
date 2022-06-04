package com.web.mtg.GatheringDecks.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class CardController {
    @Autowired
    private CardRepo repo;

    @Autowired
    private DeckRepo repoDeck;

    @GetMapping("/decks/cards/new/{id}")
    public String save(Model model, HttpServletRequest request, @PathVariable int id)
            throws UnsupportedEncodingException {
        model.addAttribute("userName", CookieService.getCookie(request, "userName"));
        model.addAttribute("userId", CookieService.getCookie(request, "userId"));
        Optional<Deck> deck = repoDeck.findById(id);
        if (deck != null)
            model.addAttribute("deck", deck.get());

        String url = "https://gathering-deck-api.herokuapp.com/cards";
        RestTemplate rTemplate = new RestTemplate();
        List<Card> cards = ArrayToListConversion(rTemplate.getForObject(url, Card[].class));
        model.addAttribute("cards", cards);

        return "deckList/cards/edit/novo";
    }

    public static <T> List<T> ArrayToListConversion(T array[]) {
        List<T> list = new ArrayList<>();
        for (T t : array) {
            list.add(t);
        }
        return list;
    }

    @PostMapping("/card/create/{id}")
    public String create(Model model,Card card, HttpServletRequest request, @PathVariable int id)
            throws NumberFormatException, UnsupportedEncodingException {
        model.addAttribute("userName", CookieService.getCookie(request, "userName"));
        model.addAttribute("userId", CookieService.getCookie(request, "userId"));
        Optional<Deck> deck = repoDeck.findById(id);
        model.addAttribute("deck", deck.get());
        String url = "https://gathering-deck-api.herokuapp.com/cards/";
        RestTemplate rTemplate = new RestTemplate();
        List<Card> cards = ArrayToListConversion(rTemplate.getForObject(url, Card[].class));
        for (Card cardEach : cards){
           if(cardEach.getId()==card.getId()){ 
               card.setName(cardEach.getName());
               card.setEdition(cardEach.getEdition());
               card.setLanguage(cardEach.getLanguage());
               card.setFoil(cardEach.getFoil());
               card.setPrice(cardEach.getPrice());
               card.setAmounts(cardEach.getAmounts());
        }
        }
        card.setDeck(deck.get());
         
        repo.save(card);
        return "redirect:/decks";
    }

    @GetMapping("/decks/cards/view/{id}")
    public String indexView(@PathVariable int id, Model model, HttpServletRequest request)
            throws UnsupportedEncodingException {
        model.addAttribute("userName", CookieService.getCookie(request, "userName"));
        model.addAttribute("userId", CookieService.getCookie(request, "userId"));
        Optional<Deck> deck = repoDeck.findById(id);
        model.addAttribute("deck", deck.get());
        List<Card> cards = repo.findByDeck(id);
        model.addAttribute("cards", cards);
        return "deckList/cards/view/index";

    }

    @GetMapping("/cards/edit/{id}")
    public String indexEdit(@PathVariable int id, Model model, HttpServletRequest request)
            throws UnsupportedEncodingException {
        model.addAttribute("userName", CookieService.getCookie(request, "userName"));
        model.addAttribute("userId", CookieService.getCookie(request, "userId"));
        Optional<Deck> deck = repoDeck.findById(id);
        if (deck != null)
            model.addAttribute("deck", deck.get());
        List<Card> cards = repo.findByDeck(id);
        if (cards != null)
            model.addAttribute("cards", cards);
        return "deckList/cards/edit/index";
    }

    @GetMapping("/decks/cards/{id}/delete")
    public String delete(Model model, @PathVariable int id, HttpServletRequest request) throws UnsupportedEncodingException {
        model.addAttribute("userName", CookieService.getCookie(request, "userName"));
        model.addAttribute("userId", CookieService.getCookie(request, "userId"));
        repo.deleteById(id);
    
        return "redirect:/decks";
    }

    @GetMapping("/cards/generate/index")
    public String generateCard(Model model, HttpServletRequest request) throws Exception {
        model.addAttribute("userName", CookieService.getCookie(request, "userName"));
        model.addAttribute("userId", CookieService.getCookie(request, "userId"));
       
        return "deckList/cards/generate/index";
    }

    @PostMapping("/cards/generate")
    public String generateCard(Model model, Card card, HttpServletRequest request) throws Exception {
        model.addAttribute("userName", CookieService.getCookie(request, "userName"));
        model.addAttribute("userId", CookieService.getCookie(request, "userId"));
        
        HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		URI url= new URI("https://gathering-deck-api.herokuapp.com/cards/");
            HttpEntity<Card> requestEntity = new HttpEntity<>(card, headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Card> responseEntity = restTemplate.postForEntity(url, requestEntity, Card.class);
            int resCode = responseEntity.getStatusCode().value();
            model.addAttribute("resCode", resCode);
        // if(resCode>300 && resCode<501) throw new Exception("Erro ao processar requisição "+responseEntity.getBody().toString());
    
        return "redirect:/cards/generate/index";
    }
}
