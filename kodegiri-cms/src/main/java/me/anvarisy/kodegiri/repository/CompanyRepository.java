package me.anvarisy.kodegiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.anvarisy.kodegiri.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
    
}
