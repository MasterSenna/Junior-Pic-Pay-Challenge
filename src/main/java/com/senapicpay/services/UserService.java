package com.senapicpay.services;

import com.senapicpay.domain.user.User;
import com.senapicpay.domain.user.UserType;
import com.senapicpay.ropositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;



@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public void validateTransaction (User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario do tipo Lojista não está autorizado a realizar transação");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }

    }

    public User findUserById(Long id) throws Exception{
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontardo"));

    }

    public void saveUser(User user){
       this.repository.save(user) ;
    }


}
