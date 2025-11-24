package com.employee.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.entity.Application;
import com.employee.entity.Document;
import com.employee.repository.ApplicationRepository;
import com.employee.repository.DocumentRepository;
import com.employee.service.DocumentService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class DocumentServiceImpl implements DocumentService {

	private final DocumentRepository documentRepository;
	private final ApplicationRepository applicationRepository;

	public DocumentServiceImpl(DocumentRepository documentRepository, ApplicationRepository applicationRepository) {
		this.documentRepository = documentRepository;
		this.applicationRepository = applicationRepository;
	}

	@Override
	public Document deleteDocumentById(Long id) {
		Document document = documentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Document with given id" + id + " is not found"));
		documentRepository.deleteById(id);
		return document;
	}

	@Override
	public Document uploadDocument(Long applicationId, Document document) {
		// finding application with id
		Application application = applicationRepository.findById(applicationId)
				.orElseThrow(() -> new RuntimeException("Application with given id" + applicationId + " is not found"));

		// relationship
		document.setApplication(application);

		return documentRepository.save(document);
	}

	@Override
	public Document getDocumentById(Long docId) {
		return documentRepository.findById(docId)
				.orElseThrow(() -> new RuntimeException("Document with id " + docId + " not found"));
	}

	@Override
	public List<Document> getDocumentsByApplicationId(Long applicationId) {
		Application application = applicationRepository.findById(applicationId)
				.orElseThrow(() -> new RuntimeException("Application not found"));
		return documentRepository.findByApplication(application);
	}
}
