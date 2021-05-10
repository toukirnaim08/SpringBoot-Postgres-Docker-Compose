package com.Abacc.Adelaide.Controllers;

import com.Abacc.Adelaide.Models.MemberRegistration;
import com.Abacc.Adelaide.Repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

	@Autowired
	private RegistrationRepository repository;

	@GetMapping("/allmembers")
	public List<MemberRegistration> findAllObjects()
	{
		return this.repository.findAll();
	}
}
