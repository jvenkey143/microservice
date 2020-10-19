package com.venkey.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.venkey.model.Product;
import com.venkey.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository repository;
	
	@GetMapping("/add")
	public String getProductForm(Model model) {
		Product product=new Product();
		model.addAttribute(product);
		return "addForm";
	}
	
	@PostMapping("/saveProduct")
	public String addProduct(@ModelAttribute Product product,Model model) {
		com.venkey.entity.Product prod=new com.venkey.entity.Product();
		BeanUtils.copyProperties(product, prod);
		repository.save(prod);
		model.addAttribute("message", "Product added Successfully");
		return "success";
	}
}
