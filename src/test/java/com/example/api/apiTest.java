package com.example.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.api.controller.ResumeController;
import com.example.api.model.Resume;
import com.example.api.service.ResumeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ResumeController.class)
public class apiTest {

	@Autowired private ObjectMapper objectMapper;
	@Autowired private MockMvc mockMvc;
	@MockBean private ResumeService resumeService;
	
	//post Test
	@Test
    public void postReq() throws Exception {
        Resume resume = new Resume();
        resume.setEmail("12345");
 
        String requestBody = objectMapper.writeValueAsString(resume);
 
        mockMvc.perform(post("/api/resumes").contentType("application/json")
                .content(requestBody))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
        ;
    }
	
	//get Test
	@Test
	public void getReq() throws Exception{
		Resume resume = new Resume();
		resume.setEmail("john@gmail");
		resume.setName("John");
		resume.setResumeId(11);
		
		Mockito.when(resumeService.getResumeById(Long.valueOf(11))).thenReturn(resume);

		mockMvc.perform(get("/api/resumes/11"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.email", is("john@gmail")))
        .andDo(print());
	}
	
	//get all Test empty
	@Test
	public void getAllReq() throws Exception {
	    Mockito.when(resumeService.getAllResumes()).thenReturn(new ArrayList<>());
	 
	    mockMvc.perform(get("/api/resumes"))
	        .andExpect(content().string("[]"))
	        .andDo(print());
	}
}
