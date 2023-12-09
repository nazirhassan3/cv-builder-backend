package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Resume;
import com.example.api.service.ResumeService;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

	private final ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		this.resumeService = resumeService;
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Resume getResumeById(@PathVariable Long id) {
		return resumeService.getResumeById(id);
	}

	@CrossOrigin
	@PostMapping
	public void addResume(@RequestBody Resume resume) {
		resumeService.saveResume(resume);
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public void updateResume(@PathVariable Long id, @RequestBody Resume resume) {
		Resume existingResume = resumeService.getResumeById(id);
		if (existingResume != null) {
			resumeService.saveResume(resume);
		}
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public void deleteResume(@PathVariable Long id) {
		resumeService.deleteResume(id);
	}
	
	@CrossOrigin
	@GetMapping
    public List<Resume> getAllResumes() {
        return resumeService.getAllResumes();
    }
}
