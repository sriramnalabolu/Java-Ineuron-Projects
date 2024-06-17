package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/second")
public class SecondController 
{
	@GetMapping("/welcome")
	public String someWork(Model model)
	{
		model.addAttribute("message", "Second Controller");
		return "index";
		
	}
	
	@GetMapping("/java")
	public String someOtherWork(Model model)
	{
		model.addAttribute("message", "Second Controller 2nd message");
		return "index";
		
	}
	
	@GetMapping
	public String getNames(Model model)
	{
		model.addAttribute("message", "My name is Najafi");
		return "index";
		
	}
	
	@PostMapping
	public String getAddress(Model model)
	{
		model.addAttribute("message", "Bengaluru");
		return "index";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
