package com.Abacc.Adelaide.Controllers;

import com.Abacc.Adelaide.Dto.RegistrationDto;
import com.Abacc.Adelaide.Services.UserRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/regadmin")
public class AdminRegistrationController {
	private UserRegistrationService userRegistrationService;

	public AdminRegistrationController(UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;
	}

	@ModelAttribute("member")
	public RegistrationDto registrationDto()
	{
		return new RegistrationDto();
	}

	@GetMapping
	public String goAdminRegistration()
	{
		return "adminreg";
	}

	//@RequestMapping(value = "/completeregistration", method = RequestMethod.POST)
	@PostMapping
	public String completeAdminRegistration(@ModelAttribute("member") RegistrationDto registrationDto)
	{

		this.userRegistrationService.adminSave(registrationDto);

		return "index";
	}
}

