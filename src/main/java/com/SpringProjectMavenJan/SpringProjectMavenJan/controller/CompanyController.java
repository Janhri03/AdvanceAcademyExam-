package com.SpringProjectMavenJan.SpringProjectMavenJan.controller;

import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyController {

    ResponseEntity<CompanyResponse> save(CompanySaveRequest companySaveRequest);

    ResponseEntity<List<CompanyResponse>> findAll();

    ResponseEntity<CompanyResponse> update(CompanyUpdateRequest companyUpdateRequest);

    ResponseEntity<CompanyResponse> findById(Long id);

    ResponseEntity<CompanyResponse> findByName(String name);

    ResponseEntity<HttpStatus> deleteById(Long id);

    ResponseEntity<HttpStatus> deleteByName(String name);
}
