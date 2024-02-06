package com.example.codeg.repository;

import com.example.codeg.model.Member;
import com.example.codeg.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByProjeto(Project project);
}
