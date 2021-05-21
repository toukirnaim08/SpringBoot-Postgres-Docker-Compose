package com.Abacc.Adelaide.Repositories;

//import com.Abacc.Adelaide.Models.MemberRegistration;
import com.Abacc.Adelaide.Dto.RegistrationDto;
import com.Abacc.Adelaide.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
