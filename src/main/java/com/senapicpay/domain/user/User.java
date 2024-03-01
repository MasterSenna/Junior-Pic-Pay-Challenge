package com.senapicpay.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "users") // Definindo o nome da tabela para evitar conflitos com a palavra reservada "user"
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName; // Corrigi a ortografia de "LasteName" para "lastName"
    @Column(unique=true)
    private String document;
    @Column(unique=true)
    private String email;

    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public UserType getUserType() {
        return this.userType;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal senderNewBalance) {
    }

    public String getEmail() {
        return email;
    }
}
