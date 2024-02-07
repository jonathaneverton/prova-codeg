package com.example.codeg.controller;

import com.example.codeg.enums.RiskClassification;
import com.example.codeg.enums.StatusProject;
import com.example.codeg.exceptions.CustomException;
import com.example.codeg.model.Person;
import com.example.codeg.model.Project;
import com.example.codeg.service.PersonService;
import com.example.codeg.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    ProjectService service;

    @Autowired
    PersonService personService;

    @GetMapping("/project/viewProjectList")
    public String viewProjectList(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("projectList", service.getAllProject());
        model.addAttribute("message", message);

        return "project/ViewProjectList";
    }

    @GetMapping("/project/addProject")
    public String addProject(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("managers", personService.getAllGerente());
        model.addAttribute("project", new Project());
        model.addAttribute("message", message);

        return "project/AddProject";
    }

    @PostMapping("/project/saveProject")
    public String saveProject(Project project, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdateProject(project)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/project/viewProjectList";
        }

        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/project/addProject";
    }

    @GetMapping("/project/editProject/{id}")
    public String editProject(@PathVariable Long id, Model model) {
        model.addAttribute("project", service.getProjectById(id));
        model.addAttribute("managers", personService.getAllGerente());
//        model.addAttribute("statusProject", StatusProject.values());
//        model.addAttribute("riskClassifications", RiskClassification.values());

        return "project/EditProject";
    }

    @PostMapping("/project/editSaveProject")
    public String editSaveProject(Project project, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdateProject(project)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/project/viewProjectList";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/project/editProject/" + project.getId();
    }

    @GetMapping("/project/deleteProject/{id}")
    public String deleteProject(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            if (service.deleteProject(id)) {
                redirectAttributes.addFlashAttribute("message", "Delete Success");
            } else {
                redirectAttributes.addFlashAttribute("message", "Delete Failure");
            }
        } catch (CustomException e) {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/project/viewProjectList";
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
