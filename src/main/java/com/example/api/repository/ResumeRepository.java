package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
