package com.example.desafio.model;

import com.example.desafio.enums.SignalTransactionEnum;
import com.example.desafio.enums.NatureTransactionEnum;
import com.example.desafio.enums.TypeTransactionEnum;
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

    @Enumerated(EnumType.STRING)
    private TypeTransactionEnum typeTransaction;

    @Enumerated(EnumType.STRING)
    private NatureTransactionEnum natureTransaction;

    @Enumerated(EnumType.STRING)
    private SignalTransactionEnum signalTransaction;
}
