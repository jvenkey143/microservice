package com.venkey.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.venkey.bean.Country;
import com.venkey.bean.StudentBean;
import com.venkey.dao.StudentDao;
import com.venkey.service.EmailService;

@Controller
public class StudentController {
	@Autowired
	StudentDao dao;
	
	@Autowired
	EmailService service;
	
	@InitBinder
	public  void  initBinder(WebDataBinder  webDataBinder)
	{
		SimpleDateFormat  sdf=new SimpleDateFormat("dd/MM/yyyy");
		CustomDateEditor editor=new CustomDateEditor(sdf, true);
		webDataBinder.registerCustomEditor(Date.class, editor);
	}
	
	@GetMapping("/register")
	public String getRegistrationPage(Model model) {
		List<Country> countriesList=dao.getAllCountries();
		StudentBean sb=new StudentBean();
		sb.setCountriesList(countriesList);
		model.addAttribute("studentBean", sb);
		return "registrationForm";
	}
	
	@PostMapping("/process")
	public String processRequest(@Valid @ModelAttribute StudentBean studentBean,BindingResult result,Model model) {
		if (result.hasErrors()) {
			List<Country> countriesList=dao.getAllCountries();
			studentBean.setCountriesList(countriesList);
			model.addAttribute("studentBean", studentBean);
			return "registrationForm";
		}
		else {
			boolean flag = dao.saveStudent(studentBean);
			if(flag) {
				service.emailSend(studentBean.getEmail(), studentBean.getStdName());
				return  "success";
			}
			else {
				return  "failure";
			}
		}
		
	}
}
