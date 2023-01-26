package me.anvarisy.kodegiri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.anvarisy.kodegiri.dto.Response;
import me.anvarisy.kodegiri.dto.TransactionRequest;
import me.anvarisy.kodegiri.entity.Trans;
import me.anvarisy.kodegiri.service.StockService;

@RestController
@EnableTransactionManagement
public class TransController {

    @Autowired
    private StockService service;

    @PostMapping("/transaction")
    public Response<Trans> createTransaction(@RequestBody TransactionRequest req){
        return service.productStock(req);
       
    }
}
