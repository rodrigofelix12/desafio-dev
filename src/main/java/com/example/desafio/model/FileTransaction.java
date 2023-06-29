package com.example.desafio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "FILE_TRANSACTION")
public class FileTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private TypeTransaction typeTransaction;

    @Column(name = "DATE_TRANSACTION")
    private LocalDateTime dateTransaction;

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
