package com.Abacc.Adelaide.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class HomeController {

	@GetMapping("/index")
	public String goHome()
	{
		return "index";
	}

	@GetMapping("/about")
	public String goAbout()
	{
		return "about";
	}

	@GetMapping("/school")
	public String goSchool()
	{
		return "school";
	}

	@GetMapping("/members")
	public String goMembers()
	{
		return "members";
	}

	@GetMapping("/registration")
	public String goRegistration()
	{
		return "registration";
	}

	@GetMapping("/contact")
	public String goContact()
	{
		return "contact";
	}
	@GetMapping("/memberlogin")
	public String goMemberLogin()
	{
		return "memberlogin";
	}
}
