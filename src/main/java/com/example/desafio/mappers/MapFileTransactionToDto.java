package com.example.desafio.mappers;

import com.example.desafio.dto.FileTransactionDto;
import com.example.desafio.model.FileTransaction;

public class MapFileTransactionToDto {
    public FileTransactionDto getDto(FileTransaction fileTransaction) {
        FileTransactionDto dto = new FileTransactionDto();
        dto.setTypeTransaction(fileTransaction.getTypeTransaction().getTypeTransaction().getDescription());
        dto.setDateTransaction(fileTransaction.getDateTransaction());
        dto.setValueTransaction(fileTransaction.getValueTransaction());
        dto.setCpf(fileTransaction.getCpf());
        dto.setCardNumber(fileTransaction.getCardNumber());
        dto.setHourTransaction(fileTransaction.getHourTransaction());
        dto.setStoreOwner(fileTransaction.getStoreOwner());
        dto.setStoreName(fileTransaction.getStoreName());

        return dto;
    }
}
