package com.senapicpay.dtos;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long senderId, Long receiverId) {
    public Long getSenderId() {
        return this.senderId;
    }

    public Long getReceiverId() {
        return this.receiverId;
    }

    public BigDecimal Value() {
        return value;
    }
}
