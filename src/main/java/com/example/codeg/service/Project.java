package com.example.codeg.service;

import com.example.codeg.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Project {
    @Autowired
    private IProjectRepository repository;

    public List<com.example.codeg.model.Project> getAllPerson() {
        List<com.example.codeg.model.Project> projectList = new ArrayList<>();
        repository.findAll().forEach(project -> projectList.add(project));

        return projectList;
    }

    public com.example.codeg.model.Project getProjectById(Long id) {
        return repository.findById(id).get();
    }

    public boolean saveOrUpdateProject(com.example.codeg.model.Project project) {
        com.example.codeg.model.Project updatedProject = repository.save(project);

        return repository.findById(updatedProject.getId()).isPresent();
    }

    public boolean deleteProject(Long id) {
        repository.deleteById(id);

        return repository.findById(id).isPresent();
    }

}
