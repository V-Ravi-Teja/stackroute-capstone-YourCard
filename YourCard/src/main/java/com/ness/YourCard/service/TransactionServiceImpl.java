package com.ness.YourCard.service;

import com.ness.YourCard.DTO.TransactionDTO;
import com.ness.YourCard.DTO.UserDTO;
import com.ness.YourCard.Exception.NotFoundException;
import com.ness.YourCard.entity.Category;
import com.ness.YourCard.entity.Transaction;
import com.ness.YourCard.entity.User;
import com.ness.YourCard.repository.TransactionRepository;
import com.ness.YourCard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class TransactionServiceImpl implements TransactionService{
    @Autowired
    public TransactionRepository transactionRepository;
    @Autowired
    public UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Override
    public Integer addTransaction(TransactionDTO transactionDto){
        Transaction transaction=new Transaction();
        transaction.setTransactionId(transactionDto.getTransactionId());
        transaction.setUser(transactionDto.getUser());
        transaction.setMerchant(transactionDto.getMerchant());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setDate(transactionDto.getDate());
        Optional<User> optional = userRepository.findById(transactionDto.getUser().getUserId());
        User user = optional.get();
        transaction.setUser(user);
        transactionRepository.save(transaction);
        return transaction.getTransactionId();
    }

    @Override
    public List<TransactionDTO> getallTransaction(Integer userid){
        List<Transaction> transactions=transactionRepository.findAllByUserId(userid);
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
    @Override
    public void updateTransactionDetails(Integer TransactionId, TransactionDTO transactionDTO){

        Optional<Transaction> optional = transactionRepository.findById(TransactionId);
        Transaction transaction =optional.get();
        //transaction.setUser(transactionDTO);
        transaction.setMerchant(transactionDTO.getMerchant());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setDate(transactionDTO.getDate());
        //transaction.setCategory(transactionDTO.getCategory());
        transactionRepository.save(transaction);



    }
    @Override
    public  void deleteTransaction(Integer TransactionId){
//        Optional<Transaction> optional = transactionRepository.findById(TransactionId);
//        Transaction transaction = optional.get();
        transactionRepository.deleteByTransactionId(TransactionId);
    }
    public boolean checkIfTransactionPresent(Integer TransactionId) {
        Optional<Transaction> transaction = this.transactionRepository.findById(TransactionId);
        return transaction.isPresent();
    }

    @Override
    public List<TransactionDTO> getTxByCategory(List<TransactionDTO> T, Category C) {
        List<TransactionDTO> txByCategory = T.stream().
                filter(s -> C.equals(s.getCategory())).
                collect(Collectors.toList());
        return txByCategory;
    }
    public Integer  getCardBalanceLeft(int userId) {

       Optional<User> user1 = userRepository.findById(userId);
       User user=user1.get();


       Integer  totalTransactionAmount = transactionRepository.getTotalTransactionAmountByUser(user);


       Integer  cardBalanceLeft = user.getUserLimit()-(totalTransactionAmount);

       return cardBalanceLeft;
    }


}