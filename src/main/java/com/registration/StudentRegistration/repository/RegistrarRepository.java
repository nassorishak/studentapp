package com.registration.StudentRegistration.repository;

import com.registration.StudentRegistration.model.Registrar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrarRepository extends JpaRepository<Registrar,Integer> {
}
