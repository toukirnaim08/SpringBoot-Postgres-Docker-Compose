package com.Abacc.Adelaide.Controllers;

import com.Abacc.Adelaide.Models.MemberRegistration;
import com.Abacc.Adelaide.Repositories.RegistrationRepository;
import com.Abacc.Adelaide.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

	@Autowired
	private RegisterService registerService;

	@RequestMapping(value = "/completeregistration", method = RequestMethod.POST)
	public String completeRegistration(@ModelAttribute("SpringWeb")MemberRegistration reg)
	{

		this.registerService.saveNewMember(reg);

		return "index";
	}
}
