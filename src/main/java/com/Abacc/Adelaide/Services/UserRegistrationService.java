package com.Abacc.Adelaide.Services;

import com.Abacc.Adelaide.Dto.RegistrationDto;
import com.Abacc.Adelaide.Models.User;

public interface UserRegistrationService {
	User save(RegistrationDto registrationDto);
}
