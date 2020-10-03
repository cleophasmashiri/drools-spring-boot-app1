package com.example.droolsapp1.service;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.droolsapp1.model.Applicant;
import com.example.droolsapp1.model.SuggestedRole;

@Service
public class ApplicantService {

	@Autowired
	KieSession kieSession;

	public SuggestedRole suggestRole(Applicant a, SuggestedRole r) {
		
		kieSession.insert(a);
		kieSession.setGlobal("suggestedRole", r);
		kieSession.fireAllRules();
		return r;
		
	}

}
