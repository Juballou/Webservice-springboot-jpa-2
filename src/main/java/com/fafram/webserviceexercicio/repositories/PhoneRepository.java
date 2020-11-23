package com.fafram.webserviceexercicio.repositories;

import com.fafram.webserviceexercicio.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
