package com.example.jspdemo.repository;

import com.example.jspdemo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project, Long> {
}
