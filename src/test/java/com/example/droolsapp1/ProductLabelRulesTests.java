package com.example.droolsapp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.droolsapp1.model.Product;
import com.example.droolsapp1.service.ProductService;

@SpringBootTest
public class ProductLabelRulesTests {
	
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void givenProductTypeElectronicThenLabelShouldBeBarCode() {
		
		Product p = new Product("Microwave", "Electronic");
		
		p = this.productService.applyLabel(p);
		
		assertEquals("BarCode", p.getLabel());
		
	}
	
	@Test
	public void givenProductTypeBookThenLabelShouldBeBarCode() {
		
		Product p = new Product("Book 1", "Book");
		
		p = this.productService.applyLabel(p);
		
		assertEquals("ISBN", p.getLabel());
		
	}
	
	@Test
	public void givenProductTypeCDThenLabelShouldBeVolumeNo() {
		
		Product p = new Product("CD 1", "CD");
		
		p = this.productService.applyLabel(p);
		
		assertEquals("VolumeNo.", p.getLabel());
		
	}
	
	

}
