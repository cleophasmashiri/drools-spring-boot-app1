package com.example.droolsapp1.service;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.droolsapp1.model.Product;



@Service
public class ProductService {
	
	@Autowired
	private KieSession s;

	public Product applyLabel(Product p) {
		
		s.insert(p);
		s.fireAllRules();
		return p;
	}
	
}
