package com.Abacc.Adelaide.Services;

import com.Abacc.Adelaide.Dto.RegistrationDto;
import com.Abacc.Adelaide.Models.Role;
import com.Abacc.Adelaide.Models.User;
import com.Abacc.Adelaide.Repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{

	private RegistrationRepository registrationRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserRegistrationServiceImpl(RegistrationRepository registrationRepository) {
		this.registrationRepository = registrationRepository;
	}

	@Override
	public User save(RegistrationDto registrationDto) {

		User user = new User(registrationDto.getUsername(), registrationDto.getFirstname(), registrationDto.getLastname(),
				registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),
				passwordEncoder.encode(registrationDto.getConfirmpassword()),
				registrationDto.getSuburb(), Arrays.asList(new Role("ROLE_Member")));

		return registrationRepository.save(user);
	}

	@Override
	public User adminSave(RegistrationDto registrationDto) {
		User user = new User(registrationDto.getUsername(), registrationDto.getFirstname(), registrationDto.getLastname(),
				registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),
				passwordEncoder.encode(registrationDto.getConfirmpassword()),
				registrationDto.getSuburb(), Arrays.asList(new Role("ROLE_Admin")));

		return registrationRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

		User user = registrationRepository.findByEmail(s);
		if(user==null)
		{
			throw new UsernameNotFoundException("user not found");
		}

		return new org.springframework.security.core.userdetails
				.User(user.getEmail(), user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles)
	{
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
