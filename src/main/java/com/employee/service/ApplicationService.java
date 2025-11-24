package com.employee.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.employee.entity.Application;
import com.employee.entity.Status;

public interface ApplicationService {

	Application createApplication(Application application);

	Application getApplicationById(Long id);

	Page<Application> getApplications(Status status, String applicantName, String position, Pageable pageable);

	Application updateApplicationById(Long id, Application application);

	Application updateApplicationByStatus(Long id, Status status);

	Application deleteApplicationById(Long id);
}
