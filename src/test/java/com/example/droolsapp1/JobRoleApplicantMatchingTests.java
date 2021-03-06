package com.example.droolsapp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.droolsapp1.model.Applicant;
import com.example.droolsapp1.model.SuggestedRole;
import com.example.droolsapp1.service.ApplicantService;

@SpringBootTest
class JobRoleApplicantMatchingTests {
	
	@Autowired
	ApplicantService applicantService;	 

	@Test
	void givenApplicantIsMatchForManagerRoleShouldSuggestManagerRole() {
		
		Applicant a = new Applicant("John Smith", 37, 1600000.0, 11);
		
		SuggestedRole r = new SuggestedRole();
		
		applicantService.suggestRole(a, r);
		
		assertEquals("Manager", r.getRole());
			
	}
	
	@Test
	void givenApplicantIsMatchForSeniorDeveloperRoleShouldSuggestSeniorDeveloperRole() {
		
		Applicant a = new Applicant("John Smith", 37, 1400000.0, 8);
		
		SuggestedRole r = new SuggestedRole();
		
		applicantService.suggestRole(a, r);
		
		assertEquals("SeniorDeveloper", r.getRole());
			
	}
	
	@Test
	void givenApplicantIsMatchForDeveloperRoleShouldSuggestDeveloperRole() {
		
		Applicant a = new Applicant("John Smith", 37, 800000.0, 1);
		
		SuggestedRole r = new SuggestedRole();
		
		applicantService.suggestRole(a, r);
		
		assertEquals("Developer", r.getRole());
			
	}
	
	

}
