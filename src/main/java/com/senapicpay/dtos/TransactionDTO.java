package com.senapicpay.dtos;

import java.math.BigDecimal;

public class TransactionDTO {
    private BigDecimal value;
    private Long senderId;
    private Long receiverId;

    // Construtores, getters e setters
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }
}
