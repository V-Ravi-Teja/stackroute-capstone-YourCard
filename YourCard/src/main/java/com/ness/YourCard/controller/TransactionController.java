package com.ness.YourCard.controller;


import com.ness.YourCard.DTO.TransactionDTO;
import com.ness.YourCard.DTO.UserDTO;
import com.ness.YourCard.service.TransactionService;
import com.ness.YourCard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/yourcard")
public class TransactionController {
@Autowired
TransactionService transactionService;
@Autowired
public UserService userService;

    @PostMapping(value="/createTransaction")
        public String addTransaction(@RequestBody TransactionDTO transactionDTO){
    //    check if user is in bank records
        if(userService.checkIfUserPresent(transactionDTO.getUser().getUserId())){
    //    adds transaction into repository
        Integer transactionId=transactionService.addTransaction(transactionDTO);
        return "transaction created wit id:"+transactionId;
        }else{
            return "No such user present";
        }
    }
    @GetMapping(value = "/GetAllTransaction/{userId}")
        public List<TransactionDTO> getAllTransaction(@PathVariable Integer userId){
        List<TransactionDTO> transactionDTO=transactionService.getallTransaction(userId);
        return transactionDTO;
    }
    @Transactional
    @PutMapping(value= "/UpdateTransaction/{TransactionId}")
    public String updateCustomer(@PathVariable Integer TransactionId, @RequestBody TransactionDTO transactionDTO) {
        transactionService.updateTransactionDetails(TransactionId,transactionDTO);
        return "transaction with id: " + TransactionId + " updated succesfully";
    }


    @Transactional
    @DeleteMapping(value = "/DeleteTransaction/{TransactionId}")
     public String delTransaction(@PathVariable Integer TransactionId){
            transactionService.deleteTransaction(TransactionId);
            return " Transaction with id" + TransactionId + " deleted successfully";
        }


}
