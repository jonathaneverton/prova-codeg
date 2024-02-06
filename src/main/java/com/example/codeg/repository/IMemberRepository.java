package com.example.codeg.repository;

import com.example.codeg.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMemberRepository extends JpaRepository<Member, Long> {
}
