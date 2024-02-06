package com.example.codeg.service;

import com.example.codeg.model.Member;
import com.example.codeg.repository.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private IMemberRepository repository;

    public List<Member> getAllMember() {
        List<Member> memberList = new ArrayList<>();
        repository.findAll().forEach(member -> memberList.add(member));

        return memberList;
    }

    public Member getMemberById(Long id) {
        return repository.findById(id).get();
    }

    public boolean saveOrUpdateMember(Member member) {
        Member updatedMember = repository.save(member);

        return repository.findById(updatedMember.getId()).isPresent();
    }

    public boolean deleteMember(Long id) {
        repository.deleteById(id);

        return repository.findById(id).isPresent();
    }
    
}
