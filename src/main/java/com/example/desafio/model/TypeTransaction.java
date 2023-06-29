package com.example.desafio.model;

import com.example.desafio.enums.SignalTransactionEnum;
import com.example.desafio.enums.NatureTransactionEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TYPE_TRANSACTION")
public class TypeTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "typeTransaction")
    private FileTransaction fileTransaction;

    @Column(name = "DEBIT")
    private String debit;

    @Column(name = "TICKET")
    private String ticket;

    @Column(name = "FUNDING")
    private String funding;

    @Column(name = "CREDIT")
    private String credit;

    @Column(name = "FUNDING_RECEIVED")
    private String fundingReceived;

    @Column(name = "SALES")
    private String sales;

    @Column(name = "TED_RECEIVED")
    private String TedReceived;

    @Column(name = "DOC_RECEIVED")
    private String DocReceived;

    @Column(name = "RENT")
    private String rent;

    @Enumerated(EnumType.STRING)
    private List<NatureTransactionEnum> listNatureTransaction;

    @Enumerated(EnumType.STRING)
    private List<SignalTransactionEnum> listSignalTransaction;
}
