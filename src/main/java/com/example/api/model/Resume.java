package com.example.api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resume_id")
	private int resumeId;
	private String name;
	private String jobTitle;
	private String phone;
	private String email;
	private String address;
	private String summary;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name= "resume_id")
	private List<WorkExperience> workExperience;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name= "resume_id")
	private List<Education> education;
	private List<String> skills;
	private List<String> sectionOrder;

	public Resume() {
	}

	public Resume(int resumeId, String name, String jobTitle, String phone, String email, String address,
			String summary, List<WorkExperience> workExperience, List<Education> education, List<String> skills,
			List<String> sectionOrder) {
		super();
		this.resumeId = resumeId;
		this.name = name;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.summary = summary;
		this.workExperience = workExperience;
		this.education = education;
		this.skills = skills;
		this.sectionOrder = sectionOrder;
	}

	public List<String> getSectionOrder() {
		return sectionOrder;
	}

	public void setSectionOrder(List<String> sectionOrder) {
		this.sectionOrder = sectionOrder;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<WorkExperience> getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(List<WorkExperience> workExperience) {
		this.workExperience = workExperience;
	}

	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

}
