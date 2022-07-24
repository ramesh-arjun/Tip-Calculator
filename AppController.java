    package com.tip.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.tip.calc.data.AccountRepository;

@Controller
public class AppController {
	@Autowired
	private AccountRepository repository;

	
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	
}

    
