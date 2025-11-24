package com.employee.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employee.entity.Application;
import com.employee.entity.Status;
import com.employee.repository.ApplicationRepository;
import com.employee.service.ApplicationService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ApplicationServiceImpl implements ApplicationService {

	private final ApplicationRepository applicationRepository;

	public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}

	@Override
	public Application createApplication(Application application) {
		return applicationRepository.save(application);
	}

	@Override
	public Application getApplicationById(Long id) {
		return applicationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Application not found with id " + id));
	}

	@Override
	public Page<Application> getApplications(Status status, String applicantName, String position, Pageable pageable) {
		if (applicantName == null)
			applicantName = "";
		if (position == null)
			position = "";

		if (status != null) {
			return applicationRepository
					.findByStatusAndApplicantNameContainingIgnoreCaseAndPositionContainingIgnoreCase(status,
							applicantName, position, pageable);
		} else {
			return applicationRepository.findByApplicantNameContainingIgnoreCaseAndPositionContainingIgnoreCase(
					applicantName, position, pageable);
		}
	}

	@Override
	public Application updateApplicationById(Long id, Application application) {
		Application existingApp = getApplicationById(id);
		if (existingApp == null) {
			return null; // or throw ResourceNotFoundException
		}

		// Update all fields
		existingApp.setApplicantName(application.getApplicantName());
		existingApp.setEmail(application.getEmail());
		existingApp.setPosition(application.getPosition());
		existingApp.setStatus(application.getStatus());

		// Update documents if sent
		// existingApp.setDocument(application.getDocument());

		return applicationRepository.save(existingApp);
	}

	@Override
	public Application updateApplicationByStatus(Long id, Status status) {
		Application application = applicationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Application not found with id " + id));
		application.setStatus(status);
		return applicationRepository.save(application);
	}

	@Override
	public Application deleteApplicationById(Long id) {
		Application application = applicationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Application not found with id " + id));
		applicationRepository.delete(application);
		return application;
	}

}
