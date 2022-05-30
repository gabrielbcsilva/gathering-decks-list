package com.web.mtg.GatheringDecks.controllers;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.web.mtg.GatheringDecks.models.Administrator;
import com.web.mtg.GatheringDecks.repositories.AdministratorsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdministratorsController {
   @Autowired
    private AdministratorsRepo repo;

    @GetMapping("/administrators")
    public String index(Model model){
        List<Administrator> administrators = (List<Administrator>)repo.findAll();
        model.addAttribute("administrator", administrators);
        
        return "administrators/index";
    }
    @GetMapping("/administrators/novo")
    public String novo(){
              
        return "administrators/novo";
    }
    @PostMapping("/administrators/criar")
    public String criar(Administrator administrator){
              repo.save(administrator);
        return "redirect:/administrators";
    }
    @GetMapping("/administrators/{id}/excluir")
    public String excluir(@PathVariable int id){
              repo.deleteById(id);
        return "redirect:/administrators";
    }
    @PostMapping("/administrators/{id}/atualizar")
    public String atualizar(@PathVariable int id, Administrator administrator){
        if(!repo.exist(id)) return "redirect:/administrators"; 
        repo.save(administrator);
        return "redirect:/administrators";
    }
    @GetMapping("/administrators/{id}")
    public String buscar(@PathVariable int id,Model model){
          Optional<Administrator> adm=  repo.findById(id);
          try {
              model.addAttribute("administrator", adm.get());
          } catch (Exception e) {
            return "redirect:/administrators";
          }
        return "/administrators/atualizar";
    }
}
