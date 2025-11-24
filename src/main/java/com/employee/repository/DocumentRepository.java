package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Application;
import com.employee.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	List<Document> findByApplication(Application application);

}
