package com.employee.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Application;
import com.employee.entity.Status;
import com.employee.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

	private final ApplicationService applicationService;

	public ApplicationController(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@PostMapping
	public Application createApplication(@RequestBody Application application) {
		return applicationService.createApplication(application);
	}

	@GetMapping("/{id}")
	public Application getApplicationById(@PathVariable Long id) {
		return applicationService.getApplicationById(id);
	}

	@GetMapping
	public Page<Application> getApplications(@RequestParam(required = false) Status status,
			@RequestParam(required = false) String applicantName, @RequestParam(required = false) String position,
			Pageable pageable) {
		return applicationService.getApplications(status, applicantName, position, pageable);
	}

	@PutMapping("/{id}")
	public Application updateApplicationById(@PathVariable Long id, @RequestBody Application application) {
		return applicationService.updateApplicationById(id, application);
	}

	@PatchMapping("/{id}/status")
	public Application updateApplicationByStatus(@PathVariable Long id, @RequestBody Status status) {
		return applicationService.updateApplicationByStatus(id, status);
	}
	@DeleteMapping("/{id}")
	public Application deleteApplicationById(@PathVariable Long id) {
		return applicationService.deleteApplicationById(id);
	}
}
