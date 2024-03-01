package com.senapicpay.domain.user;

import com.senapicpay.dtos.UserDTO;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName; // Adicionando o campo firstName

    private String lastName;
    @Column(unique=true)
    private String document;
    @Column(unique=true)
    private String email;
    private String password;
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User() {}

    public User(UserDTO data) {
        this.firstName = data.firstName(); // Definindo o firstName com base nos dados do DTO
        this.lastName = data.lastName();
        this.balance = data.balance();
        this.userType = data.userType();
        this.email = data.email();
        this.password = data.password();
    }

}
