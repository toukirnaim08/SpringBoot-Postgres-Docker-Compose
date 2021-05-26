package com.Abacc.Adelaide.Services;

import com.Abacc.Adelaide.Dto.RegistrationDto;
import com.Abacc.Adelaide.Models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserRegistrationService extends UserDetailsService {
	User save(RegistrationDto registrationDto);
	User adminSave(RegistrationDto registrationDto);
}
