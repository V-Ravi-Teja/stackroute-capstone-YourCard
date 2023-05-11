package com.ness.YourCard.service;

import com.ness.YourCard.DTO.TransactionDTO;
import com.ness.YourCard.DTO.UserDTO;
import com.ness.YourCard.Exception.NotFoundException;
import com.ness.YourCard.entity.Category;
import com.ness.YourCard.entity.Transaction;
import com.ness.YourCard.entity.User;
import com.ness.YourCard.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class TransactionServiceImpl implements TransactionService{
    @Autowired
    public TransactionRepository transactionRepository;
    @Autowired
    public UserService userService;
//    @Autowired
//    public CategoryService categoryService;
    @Override
    public Integer addTransaction(TransactionDTO transactionDto){
        Transaction transaction=new Transaction();
        transaction.setTransactionId(transactionDto.getTransactionId());

        transaction.setMerchant(transactionDto.getMerchant());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setDate(transactionDto.getDate());
        transactionRepository.save(transaction);
        //transaction.setUser(transactionDto.getUser().getUserId());



        //User user = userService.getUser(transactionDto.getUser().getUserId());
        //transaction.setUser(user);






        return transaction.getTransactionId();
    }

    @Override
    public List<TransactionDTO> getallTransaction(){
        List<Transaction> transactions=transactionRepository.findAll();
        List<TransactionDTO> transactionDTOs = new ArrayList<>();
        for (Transaction transaction : transactions) {
            TransactionDTO transactionDTO = new TransactionDTO();
            transactionDTO.setTransactionId(transaction.getTransactionId());
            transactionDTO.setUser(transaction.getUser());
            transactionDTO.setMerchant(transaction.getMerchant());
            transactionDTO.setAmount(transaction.getAmount());
            transactionDTO.setDate(transaction.getDate());
            transactionDTO.setCategory(transaction.getCategory());
            transactionDTOs.add(transactionDTO);
        }
        return transactionDTOs;
    }


}