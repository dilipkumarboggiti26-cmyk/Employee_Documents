package com.employee.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;

	@Column(nullable = false, length = 100)
	@JsonProperty("applicantName")
	private String applicantName;

	@Column(nullable = false)
	@JsonProperty("email")
	private String email;

	@Column(nullable = false)
	@JsonProperty("position")
	private String position;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@JsonProperty("status")
	private Status status = Status.SUBMITTED;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	@JsonProperty("submittedAt")
	private LocalDateTime submittedAt;

	@OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonProperty("document")
	private List<Document> document = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(LocalDateTime submittedAt) {
		this.submittedAt = submittedAt;
	}

	public List<Document> getDocument() {
		return document;
	}

	public void setDocument(List<Document> document) {
		this.document = document;
	}
	
}
