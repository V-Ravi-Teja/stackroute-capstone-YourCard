package com.ness.YourCard.service;

import com.ness.YourCard.DTO.TransactionDTO;

import java.util.List;

public interface TransactionService {
    public Integer addTransaction(TransactionDTO transactionDto);

  public List<TransactionDTO> getallTransaction();
}
