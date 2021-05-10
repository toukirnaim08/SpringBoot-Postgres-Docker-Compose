package com.Abacc.Adelaide.Services;

import com.Abacc.Adelaide.Models.MemberRegistration;
import com.Abacc.Adelaide.Repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

	@Autowired
	private RegistrationRepository repository;

	public void saveNewMember(MemberRegistration newMember)
	{
		this.repository.save(newMember);
	}
}
