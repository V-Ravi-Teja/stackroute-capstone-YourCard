package com.ness.YourCard.DTO;

import com.ness.YourCard.entity.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
        private int userId;
        private String userName;
        private String userPassword;
        private int userLimit;

        public int getUserId() {
                return userId;
        }

        public String getUserName() {
                return userName;
        }

        public String getUserPassword() {
                return userPassword;
        }

        public int getUserLimit() {
                return userLimit;
        }

        public List<Transaction> getTransactions() {
                return transactions;
        }

        private List<Transaction> transactions;
}