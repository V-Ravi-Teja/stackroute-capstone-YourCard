package com.ness.YourCard.DTO;

import com.ness.YourCard.entity.Category;
import com.ness.YourCard.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
        private int transactionId;

        private User user;
        public Category getCategory() {
                return category;
        }
        private String merchant;
        private BigDecimal amount;
        private LocalDate date;
        private Category category;
}
