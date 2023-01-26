package me.anvarisy.kodegiri.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.anvarisy.kodegiri.dto.Response;
import me.anvarisy.kodegiri.dto.TransactionRequest;
import me.anvarisy.kodegiri.entity.Product;
import me.anvarisy.kodegiri.entity.Trans;
import me.anvarisy.kodegiri.repository.CompanyRepository;
import me.anvarisy.kodegiri.repository.ProductRepository;
import me.anvarisy.kodegiri.repository.TransactionRepository;

@Service
public class StockService {
    @Autowired
    private ProductRepository repoP;
    @Autowired
    private CompanyRepository repoC;
    @Autowired
    private TransactionRepository repoT;

    @Transactional
    public Response<Trans> productStock(TransactionRequest req){
        LocalDateTime lt
            = LocalDateTime.now();
        if(!repoC.findById(req.getCompanyId()).isPresent())
            throw new RuntimeException("Company id not found");
        Product p = repoP.findById(req.getProductId()).get();
        if(!p.equals(null)){
            if(p.getStock()<req.getQty())
                throw new RuntimeException("Stock of product not exceed");
        p.setStock(p.getStock() - req.getQty());
        repoP.save(p);
        Trans t = repoT.save(new Trans(0, req.getProductId(), req.getCompanyId(), req.getQty(), lt));
        return new Response<Trans>(true, 201, "Successfully inserted !", t);
        }
    throw new RuntimeException("There should be a problem with product");
    }
    
}
