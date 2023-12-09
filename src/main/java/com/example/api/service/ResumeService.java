package com.example.api.service;

import java.util.List;

import com.example.api.model.Resume;

public interface ResumeService {

	Resume getResumeById(Long id);

	void saveResume(Resume resume);

	void updateResume(Resume resume);

	void deleteResume(Long id);
	
	 List<Resume> getAllResumes();
}
