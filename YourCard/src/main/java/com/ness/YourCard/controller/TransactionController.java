package com.ness.YourCard.controller;


import com.ness.YourCard.DTO.TransactionDTO;
import com.ness.YourCard.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/yourcard")
public class TransactionController {
@Autowired
    TransactionService transactionService;

@PostMapping(value="/createTransaction")
    public String addTransaction(@RequestBody TransactionDTO transactionDTO){
    Integer transactionId=transactionService.addTransaction(transactionDTO);


    return "transaction created wit id:"+transactionId;
}
@GetMapping(value = "/GetAllTransaction")
    public List<TransactionDTO> getAllTransaction(){
    List<TransactionDTO> transactionDTO=transactionService.getallTransaction();
    return transactionDTO;
}


}
