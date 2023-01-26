package me.anvarisy.kodegiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.anvarisy.kodegiri.entity.Trans;

public interface TransactionRepository extends JpaRepository<Trans, Integer>{
    
}
