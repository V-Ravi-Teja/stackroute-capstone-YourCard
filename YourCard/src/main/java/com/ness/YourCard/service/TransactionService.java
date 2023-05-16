package com.ness.YourCard.service;

import com.ness.YourCard.DTO.TransactionDTO;
import com.ness.YourCard.DTO.UserDTO;
import com.ness.YourCard.entity.Category;

import java.util.List;

public interface TransactionService {
    public Integer addTransaction(TransactionDTO transactionDto);

    public List<TransactionDTO> getallTransaction(Integer userid);

    public void updateTransactionDetails(Integer TransactionId, TransactionDTO transactionDTO);

    public void deleteTransaction(Integer TransactionId);
    boolean checkIfTransactionPresent(Integer TransactionId);

    List<TransactionDTO> getTxByCategory(List<TransactionDTO> T, Category C);
    public Integer  getCardBalanceLeft(int userId);
}