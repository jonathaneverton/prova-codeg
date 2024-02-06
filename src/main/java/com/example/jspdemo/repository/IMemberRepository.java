package com.example.jspdemo.repository;

import com.example.jspdemo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMemberRepository extends JpaRepository<Member, Long> {
}
