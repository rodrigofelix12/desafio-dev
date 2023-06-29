package com.example.desafio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class File {

    private Long id;

    private TypeTransaction typeTransaction;

    private LocalDateTime dateTransaction;

    private BigDecimal valueTransaction;

    private String cpf;

    private String cardNumber;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime hourTransaction;

    private String storeOwner;

    private String storeName;
}
