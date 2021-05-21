package com.Abacc.Adelaide.Controllers;

//import com.Abacc.Adelaide.Models.MemberRegistration;
import com.Abacc.Adelaide.Dto.RegistrationDto;
import com.Abacc.Adelaide.Models.User;
import com.Abacc.Adelaide.Repositories.RegistrationRepository;
//import com.Abacc.Adelaide.Services.RegisterService;
import com.Abacc.Adelaide.Services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {


	private UserRegistrationService userRegistrationService;

	public RegistrationController(UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;
	}

	@ModelAttribute("member")
	public RegistrationDto registrationDto()
	{
		return new RegistrationDto();
	}

	@GetMapping
	public String goRegistration()
	{
		return "registration";
	}

	//@RequestMapping(value = "/completeregistration", method = RequestMethod.POST)
	@PostMapping
	public String completeRegistration(@ModelAttribute("member") RegistrationDto registrationDto)
	{

		this.userRegistrationService.save(registrationDto);

		return "index";
	}
}
