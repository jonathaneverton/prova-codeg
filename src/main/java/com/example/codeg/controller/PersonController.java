package com.example.codeg.controller;

import com.example.codeg.exceptions.CustomException;
import com.example.codeg.model.Person;
import com.example.codeg.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping({"/", "/viewPersonList"})
    public String viewPersonList(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("personList", service.getAllPerson());
        model.addAttribute("message", message);

        return "person/ViewPersonList";
    }

    @GetMapping("/addPerson")
    public String addPerson(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("message", message);

        return "person/AddPerson";
    }

    @PostMapping("/savePerson")
    public String savePerson(Person person, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdatePerson(person)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewPersonList";
        }

        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/addPerson";
    }

    @GetMapping("/editPerson/{id}")
    public String editPerson(@PathVariable Long id, Model model) {
        model.addAttribute("person", service.getPersonById(id));

        return "person/EditPerson";
    }

    @PostMapping("/editSavePerson")
    public String editSavePerson(Person person, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdatePerson(person)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/viewPersonList";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editPerson/" + person.getId();
    }

    @GetMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            if(service.deletePerson(id)) {
                redirectAttributes.addFlashAttribute("message", "Delete Success");
            } else {
                redirectAttributes.addFlashAttribute("message", "Delete Failure");
            }
        } catch (CustomException e) {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }


        return "redirect:/viewPersonList";
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
