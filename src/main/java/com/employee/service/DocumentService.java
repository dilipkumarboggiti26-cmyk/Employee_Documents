package com.employee.service;

import java.util.List;

import com.employee.entity.Document;

public interface DocumentService {

	Document deleteDocumentById(Long id);

	Document uploadDocument(Long applicationId, Document document);

	List<Document> getDocumentsByApplicationId(Long applicationId);

	Document getDocumentById(Long docId);

}
