package com.example.codeg.controller;

import com.example.codeg.model.Person;
import com.example.codeg.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping({"/", "/viewPersonList"})
    public String viewList(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("personList", service.getAllPerson());
        model.addAttribute("message", message);

        return "ViewPersonList";
    }

    @GetMapping("/addPerson")
    public String add(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("message", message);

        return "AddPerson";
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
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("person", service.getPersonById(id));

        return "EditPerson";
    }

    @PostMapping("/editSavePerson")
    public String editSave(Person person, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdatePerson(person)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/viewPersonList";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editPerson/" + person.getId();
    }

    @GetMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (service.deletePerson(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/viewPersonList";
    }

}
