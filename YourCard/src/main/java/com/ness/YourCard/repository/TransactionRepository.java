package com.ness.YourCard.repository;

import com.ness.YourCard.entity.Transaction;
import com.ness.YourCard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("SELECT t FROM Transaction t WHERE t.user.userId = :userId")
    List<Transaction> findAllByUserId(@Param("userId") int userId);
    void deleteByTransactionId(int transactionId);
    @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t WHERE t.user = :user")
    Integer getTotalTransactionAmountByUser(@Param("user") User user);

}

