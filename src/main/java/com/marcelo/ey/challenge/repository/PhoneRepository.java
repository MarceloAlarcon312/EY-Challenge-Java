package com.marcelo.ey.challenge.repository;

import com.marcelo.ey.challenge.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, String> {
}
