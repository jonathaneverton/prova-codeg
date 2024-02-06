package com.example.codeg.service;

import com.example.codeg.model.Member;
import com.example.codeg.model.Project;
import com.example.codeg.repository.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private IMemberRepository repository;

    @Query("SELECT m FROM Member m JOIN FETCH m.projeto")
    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    @Query("SELECT DISTINCT m FROM Member m JOIN FETCH m.projeto p WHERE p = :project")
    public List<Member> getAllMembersByProject(Project project) {
        return repository.findByProjeto(project);
    }

    public Member getMemberById(Long id) {
        return repository.findById(id).get();
    }

    public boolean saveOrUpdateMember(Member member) {
        Member updatedMember = repository.save(member);

        return repository.findById(updatedMember.getId()).isPresent();
    }

    public Member saveMember(Member member) {
        return repository.save(member);
    }

    public boolean deleteMember(Long id) {
        repository.deleteById(id);

        return repository.findById(id).isPresent();
    }
    
}
