package com.example.lostpets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    PetRepository petRepository;


    @RequestMapping("/updatepage")
    public String updatepets(Model model) {
        model.addAttribute("pets", petRepository.findAll());
        return "updatepet";
    }

    @RequestMapping("/deletepet")
    public String deletepets(Model model) {
        model.addAttribute("pets", petRepository.findAll());
        return "deletepet";
    }



    @RequestMapping("/")
    public String listpets(Model model) {
        model.addAttribute("pets", petRepository.findAll());
        return "list";
    }


    @RequestMapping("/update/{id}")
    public String updatepets(@PathVariable("id") long id,Model model) {
     model.addAttribute("pet",petRepository.findOne(id));
     return "petform";

    }




    @GetMapping("/add")
    public String course(Model model){
        model.addAttribute("pet",new Pet());
        return "petform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Pet pet, BindingResult result)
    {System.out.println(result.toString());
        if(result.hasFieldErrors()) {
            return "petform";
        }
        petRepository.save(pet);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showPit(@PathVariable("id") long id, Model model){
        model.addAttribute("pet",petRepository.findOne(id));
        return"Show";
    }


    @RequestMapping("/delete/{id}")
    public String deletepet(@PathVariable("id") long id){
        petRepository.delete(id);
        return "deletepet";

    }


}