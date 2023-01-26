package me.anvarisy.kodegiri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import me.anvarisy.kodegiri.dto.Response;
import me.anvarisy.kodegiri.entity.Product;
import me.anvarisy.kodegiri.repository.ProductRepository;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository repo;
    @GetMapping("/product")
    // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Response<List<Product>> getProduct(@RequestHeader(value="Authorization") String bearer){
        return new Response<List<Product>>(true,
         200,
         "Request data product complete",
         repo.findAll());
    }
}
