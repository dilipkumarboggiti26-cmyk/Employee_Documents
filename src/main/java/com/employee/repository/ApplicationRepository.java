package com.employee.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Application;
import com.employee.entity.Status;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

	Page<Application> findByStatusAndApplicantNameContainingIgnoreCaseAndPositionContainingIgnoreCase(Status status,
			String applicantName, String position, Pageable pageable);

	Page<Application> findByApplicantNameContainingIgnoreCaseAndPositionContainingIgnoreCase(String applicantName,
			String position, Pageable pageable);
}
