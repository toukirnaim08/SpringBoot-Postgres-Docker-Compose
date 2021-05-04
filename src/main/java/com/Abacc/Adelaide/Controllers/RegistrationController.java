package com.Abacc.Adelaide.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

	@PostMapping("/completeregistration")
	public String completeRegistration()
	{
		return "index";
	}
}
