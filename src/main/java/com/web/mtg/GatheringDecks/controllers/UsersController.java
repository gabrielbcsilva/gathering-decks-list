package com.web.mtg.GatheringDecks.controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.web.mtg.GatheringDecks.models.User;
import com.web.mtg.GatheringDecks.repositories.UsersRepo;
import com.web.mtg.GatheringDecks.services.CookieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {
    @Autowired(required = true)
    private UsersRepo repo;

    @GetMapping("/users")
    public String index(Model model,HttpServletRequest request) throws UnsupportedEncodingException {
        model.addAttribute("userName",CookieService.getCookie(request, "userName"));
        model.addAttribute("userId",CookieService.getCookie(request, "userId"));
        List<User> users = (List<User>) repo.findAll();
        model.addAttribute("user", users);

        return "users/index";
    }

    @GetMapping("/users/novo")
    public String novo() {

        return "users/novo";
    }

    @PostMapping("/users/create")
    public String create(User user) {
        repo.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/delete")
    public String delete(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}/atualizar")
    public String atualizar(@PathVariable int id, User user) {
        if (!repo.exist(id))
            return "redirect:/users";
        repo.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String buscar(@PathVariable int id, Model model) {
        Optional<User> adm = repo.findById(id);
        try {
            model.addAttribute("user", adm.get());
        } catch (Exception e) {
            return "redirect:/users";
        }
        return "/users/atualizar";
    }
}
