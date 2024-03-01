package com.senapicpay.domain.transaction;

import com.senapicpay.domain.user.User;
import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private LocalDateTime timestamp;

    public void setAmount(BigDecimal transactionValue) {
    }

    public void setSender(User sender) {
    }

    public void setReceiver(User receiver) {
    }

    public void setTimestamp(LocalDateTime now) {
    }
}
