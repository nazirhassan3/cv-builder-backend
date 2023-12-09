package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.Resume;
import com.example.api.repository.ResumeRepository;

@Service
public class ResumeServiceImpl implements ResumeService {

	private final ResumeRepository resumeRepository;

	@Autowired
	public ResumeServiceImpl(ResumeRepository resumeRepository) {
		this.resumeRepository = resumeRepository;
	}

	@Override
	public Resume getResumeById(Long id) {
		Optional<Resume> optionalResume = resumeRepository.findById(id);
		return optionalResume.orElse(null);
	}

	@Override
	public void saveResume(Resume resume) {
		resumeRepository.save(resume);
	}

	@Override
	public void updateResume(Resume resume) {
		resumeRepository.save(resume);

	}

	@Override
	public void deleteResume(Long id) {
		resumeRepository.deleteById(id);
	}
	
	public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

}
