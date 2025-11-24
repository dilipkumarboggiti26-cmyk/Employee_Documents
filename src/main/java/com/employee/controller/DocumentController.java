package com.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Document;
import com.employee.repository.ApplicationRepository;
import com.employee.service.DocumentService;

@RestController
@RequestMapping("/api/document")
public class DocumentController {
	private final DocumentService documentService;

	public DocumentController(DocumentService documentService) {
		this.documentService = documentService;
	}

	@DeleteMapping("/{id}")
	public Document deleteDocumentById(@PathVariable Long id) {
		return documentService.deleteDocumentById(id);
	}

	// /api/applications/{id}/documents
	@PostMapping("/{id}/documents")
	public Document uploadDocument(@PathVariable Long id, @RequestBody Document document) {

		return documentService.uploadDocument(id, document);
	}

	@GetMapping("/applications/{id}/documents")
	public List<Document> getDocumentsByApplicationId(@PathVariable Long id) {
	    return documentService.getDocumentsByApplicationId(id);
	}

}
