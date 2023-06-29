package com.example.desafio.model;

import com.example.desafio.enums.NatureTransactionEnum;
import com.example.desafio.enums.SignalTransactionEnum;
import com.example.desafio.enums.TypeTransactionEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "FILE_TRANSACTION")
public class FileTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeTransaction typeTransaction;

    @Column(name = "DATE_TRANSACTION")
    private LocalDate dateTransaction;

    @Column(name = "VALUE_TRANSACTION")
    private BigDecimal valueTransaction;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "HOUR_TRANSACTION")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime hourTransaction;

    @Column(name = "STORE_OWNER")
    private String storeOwner;

    @Column(name = "STORE_NAME")
    private String storeName;
}
