package com.registration.StudentRegistration.repository;

import com.registration.StudentRegistration.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement,Integer> {
}
