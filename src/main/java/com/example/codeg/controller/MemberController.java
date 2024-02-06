package com.example.codeg.controller;

import com.example.codeg.dto.MemberDTO;
import com.example.codeg.model.Member;
import com.example.codeg.model.Person;
import com.example.codeg.model.Project;
import com.example.codeg.service.MemberService;
import com.example.codeg.service.PersonService;
import com.example.codeg.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    private MemberService service;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity getAllMembers() {
        List<Member> memberList = service.getAllMembers();
        return ResponseEntity.ok(memberList);
    }

    @GetMapping("/{projectId}/members")
    public List<Member> getAllMembersByProject(@PathVariable Long projectId) {
        System.out.println("ID: " + projectId);
        Project project = projectService.getProjectById(projectId);
        return service.getAllMembersByProject(project);
    }

    @PostMapping()
    public ResponseEntity addMember(@RequestBody Member data) {
        Person person = personService.getPersonById(data.getPessoa().getId());
        if (person.getFuncionario()) {
            Member newMember = service.saveMember(data);
            return new ResponseEntity<>(newMember, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(data, HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteMember(@PathVariable Long id) {
        Optional<Member> optionalProduct = Optional.ofNullable(service.getMemberById(id));
        if (optionalProduct.isPresent()) {
            service.deleteMember(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
