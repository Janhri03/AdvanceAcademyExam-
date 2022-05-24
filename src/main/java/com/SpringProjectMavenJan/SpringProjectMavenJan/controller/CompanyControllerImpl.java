package com.SpringProjectMavenJan.SpringProjectMavenJan.controller;

import com.SpringProjectMavenJan.SpringProjectMavenJan.converter.CompanyConverter;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.CompanyResponse;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.CompanySaveRequest;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.CompanyUpdateRequest;
import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Company;
import com.SpringProjectMavenJan.SpringProjectMavenJan.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/companies")
public class CompanyControllerImpl implements CompanyController{

    private final CompanyService companyService;
    private final CompanyConverter companyConverter;

    @Override
    @PostMapping
    public ResponseEntity<CompanyResponse> save(@RequestBody @Valid CompanySaveRequest companySaveRequest) {
        Company company = companyConverter.convert(companySaveRequest);
        Company savedCompany = companyService.save(company);
        CompanyResponse companyResponse = companyConverter.convert(savedCompany);
        return ResponseEntity.ok().body(companyResponse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CompanyResponse>> findAll() {
        return ResponseEntity.ok(companyService.findAll().stream().map(companyConverter::convert).collect(Collectors.toList()));
    }

    @Override
    @PutMapping(value = "/update")
    public ResponseEntity<CompanyResponse> update(@RequestBody @Valid CompanyUpdateRequest companyUpdateRequest) {
        Company company = companyConverter.convert(companyUpdateRequest);
        Company updatedCompany = companyService.update(company, company.getId());
        CompanyResponse companyResponse = companyConverter.convert(updatedCompany);
        return ResponseEntity.ok().body(companyResponse);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<CompanyResponse> findById(@PathVariable Long id) {
        Company company = companyService.findById(id);
        CompanyResponse companyResponse = companyConverter.convert(company);
        return ResponseEntity.ok().body(companyResponse);
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<CompanyResponse> findByName(@PathVariable String name) {
        Company company = companyService.findByName(name);
        CompanyResponse companyResponse = companyConverter.convert(company);
        return ResponseEntity.ok().body(companyResponse);
    }

    @Override
    @DeleteMapping(value = "/id/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        companyService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping(value = "/name/delete/{name}")
    public ResponseEntity<HttpStatus> deleteByName(@PathVariable String name) {
        companyService.deleteByName(name);
        return ResponseEntity.ok().build();
    }
}
