package com.ness.YourCard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int userId;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "UserPassword")
    private String userPassword;

    @Column(name = "UserLimit")
    private int userLimit;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;
}
