package com.example.desafio.dto;

import com.example.desafio.model.TypeTransaction;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class FileTransactionDto {
    private String typeTransaction;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDate dateTransaction;

    private BigDecimal valueTransaction;

    private String cpf;

    private String cardNumber;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime hourTransaction;

    private String storeOwner;

    private String storeName;
}
