package com.Abacc.Adelaide.Repositories;

import com.Abacc.Adelaide.Models.MemberRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<MemberRegistration, Long> {
}
