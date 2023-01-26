package me.anvarisy.kodegiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.anvarisy.kodegiri.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
