package com.example.desafio.model;

import com.example.desafio.enums.SignalTransactionEnum;
import com.example.desafio.enums.NatureTransactionEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeTransaction {

    private Long id;

    private String debit;

    private String ticket;

    private String funding;

    private String credit;

    private String fundingReceived;

    private String sales;

    private String TedReceived;

    private String DocReceived;

    private String rent;

    private NatureTransactionEnum natureTransaction;

    private SignalTransactionEnum signalTransaction;
}
