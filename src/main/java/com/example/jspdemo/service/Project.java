package com.example.jspdemo.service;

import com.example.jspdemo.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Project {
    @Autowired
    private IProjectRepository repository;

    public List<com.example.jspdemo.model.Project> getAllPerson() {
        List<com.example.jspdemo.model.Project> projectList = new ArrayList<>();
        repository.findAll().forEach(project -> projectList.add(project));

        return projectList;
    }

    public com.example.jspdemo.model.Project getProjectById(Long id) {
        return repository.findById(id).get();
    }

    public boolean saveOrUpdateProject(com.example.jspdemo.model.Project project) {
        com.example.jspdemo.model.Project updatedProject = repository.save(project);

        return repository.findById(updatedProject.getId()).isPresent();
    }

    public boolean deleteProject(Long id) {
        repository.deleteById(id);

        return repository.findById(id).isPresent();
    }

}
