package com.Abacc.Adelaide.Services;

import com.Abacc.Adelaide.Dto.RegistrationDto;
import com.Abacc.Adelaide.Models.Role;
import com.Abacc.Adelaide.Models.User;
import com.Abacc.Adelaide.Repositories.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{

	private RegistrationRepository registrationRepository;

	public UserRegistrationServiceImpl(RegistrationRepository registrationRepository) {
		this.registrationRepository = registrationRepository;
	}

	@Override
	public User save(RegistrationDto registrationDto) {

		User user = new User(registrationDto.getUsername(), registrationDto.getFirstname(), registrationDto.getLastname(),
				registrationDto.getEmail(), registrationDto.getPassword(), registrationDto.getConfirmpassword(),
				registrationDto.getSuburb(), Arrays.asList(new Role("ROLE_Member")));

		return registrationRepository.save(user);
	}
}
