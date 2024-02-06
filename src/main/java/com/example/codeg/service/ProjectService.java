package com.example.codeg.service;

import com.example.codeg.exceptions.CustomException;
import com.example.codeg.model.Person;
import com.example.codeg.model.Project;
import com.example.codeg.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private IProjectRepository repository;

//    public List<com.example.codeg.model.Project> getAllProject() {
//        List<com.example.codeg.model.Project> projectList = new ArrayList<>();
//        repository.findAll().forEach(project -> projectList.add(project));
//
//        return projectList;
//    }

    public List<Project> getAllProject() {
        List<Project> projectList = new ArrayList<>();

        // Ordena por nome em ordem crescente
        repository.findAll(Sort.by(Sort.Order.asc("id"))).forEach(projectList::add);

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
        try {
            Project project = repository.getById(id);

            if (checkStatusProject(project)) {
                repository.deleteById(id);
            } else {
                return false;
            }
        } catch (DataIntegrityViolationException e){
            throw new CustomException("Não é possível excluir a projeto devido a alguma condição específica.");
        }

        return repository.findById(id).isPresent();
    }

    private boolean checkStatusProject(Project project) {
        return !project.getStatus().equals("INICIADO") &&
                !project.getStatus().equals("EM_ANDAMENTO") &&
                !project.getStatus().equals("ENCERRADO");
    }

}
