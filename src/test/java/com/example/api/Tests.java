package com.example.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.api.model.Resume;
import com.example.api.repository.ResumeRepository;

@DataJpaTest
public class Tests {

	@Autowired
	private ResumeRepository repository;

	@Test
	public void emptyCheck() {
		Iterable<Resume> resumes = repository.findAll();
		assertThat(resumes).isEmpty();
	}
	
	@Test
	public void checkForDataFromFile() {
		Iterable<Resume> resumes = repository.findAll();
		assertThat(resumes).isNotEmpty();
	}

	@Test
	public void checkResumeByValues() {

		Resume resume = new Resume();
		resume.setName("Nazir");
		repository.save(resume);

		assertThat(resume).hasFieldOrPropertyWithValue("name", "Nazir");
		assertThat(resume).hasFieldOrPropertyWithValue("email", "naz@gmail.com");
	}
}

//{
//    "id": 1,
//    "name": "Naz",
//    "jobTitle": "Dev",
//    "phone": "03994002002",
//    "email": "naz@gmail.com",
//    "address": null,
//    "summary": "thisis the summary",
//    "workExperience": [
//        {
//            "id": 1,
//            "jobTitle": "dev",
//            "company": "hcl",
//            "joinDate": "1970-01-01",
//            "till": null,
//            "jobRole": "dev dping that and this",
//            "resume": null
//        }
//    ],
//    "education": null,
//    "skills": null
//}