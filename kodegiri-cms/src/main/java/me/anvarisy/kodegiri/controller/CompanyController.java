package me.anvarisy.kodegiri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import me.anvarisy.kodegiri.dto.CompanyRequest;
import me.anvarisy.kodegiri.dto.Response;
import me.anvarisy.kodegiri.entity.Company;
import me.anvarisy.kodegiri.repository.CompanyRepository;

@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository repo;

    @GetMapping("/company")
    public Response<List<Company>> getAllCompany(){
        return new Response<List<Company>>(true, 201, "Insert complete", repo.findAll());
    }

    @PostMapping("/company")
    public Response<Company> insertCompany(@Valid @RequestBody CompanyRequest req){
        Company c = repo.save(new Company(0, req.getCompanyId(), req.getCompanyName()));
        return new Response<Company>(true, 201, "Insert complete", c);
    }
}
