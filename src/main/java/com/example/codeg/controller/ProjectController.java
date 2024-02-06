package com.example.codeg.controller;

import com.example.codeg.enums.RiskClassification;
import com.example.codeg.enums.StatusProject;
import com.example.codeg.model.Person;
import com.example.codeg.model.Project;
import com.example.codeg.service.PersonService;
import com.example.codeg.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    ProjectService service;

    @Autowired
    PersonService personService;

    @GetMapping({"/", "/viewProjectList"})
    public String viewProjectList(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("projectList", service.getAllProject());
        model.addAttribute("message", message);

        return "project/ViewProjectList";
    }

    @GetMapping("/addProject")
    public String addProject(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("managers", personService.getAllGerente());
        model.addAttribute("project", new Project());
        model.addAttribute("message", message);

        return "project/AddProject";
    }

    @PostMapping("/saveProject")
    public String saveProject(Project project, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdateProject(project)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewProjectList";
        }

        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/addProject";
    }

    @GetMapping("/editProject/{id}")
    public String editProject(@PathVariable Long id, Model model) {
        model.addAttribute("project", service.getProjectById(id));
        model.addAttribute("managers", personService.getAllGerente());
//        model.addAttribute("statusProject", StatusProject.values());
//        model.addAttribute("riskClassifications", RiskClassification.values());

        return "project/EditProject";
    }

    @PostMapping("/editSaveProject")
    public String editSaveProject(Project project, RedirectAttributes redirectAttributes) {
        if (service.saveOrUpdateProject(project)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/viewProjectList";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editProject/" + project.getId();
    }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (service.deleteProject(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/viewProjectList";
    }

}
