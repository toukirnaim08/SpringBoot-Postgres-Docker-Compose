package com.Abacc.Adelaide.Services;

///import com.Abacc.Adelaide.Models.MemberRegistration;
import com.Abacc.Adelaide.Models.User;
import com.Abacc.Adelaide.Repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

	@Autowired
	private RegistrationRepository repository;

	public void saveNewMember(User newMember)
	{
		this.repository.save(newMember);
	}
}
