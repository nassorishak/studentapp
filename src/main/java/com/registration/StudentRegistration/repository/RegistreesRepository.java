package com.registration.StudentRegistration.repository;

import com.registration.StudentRegistration.model.Registrees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistreesRepository extends JpaRepository<Registrees,Integer> {
}
