package com.example.desafio.enums;

import lombok.Getter;

@Getter
public enum TypeTransactionEnum {
    DEBIT("1", "Débito"),
    TICKET("2", "Boleto"),
    FUNDING("3", "Financiamento"),
    CREDIT("4", "Crédito"),
    FUNDING_RECEIVED("5", "Recebimento Empréstimo"),
    SALES("6", "Vendas"),
    TED_RECEIVED("7", "Recebimento TED"),
    DOC_RECEIVED("8", "Recebimento DOC"),
    RENT("9", "Aluguel");

    private String description;
    private String order;

    TypeTransactionEnum(String order, String description) {
        this.description = description;
        this.order = order;
    }

    public static TypeTransactionEnum valueOfLabel(String order) {
        for (TypeTransactionEnum e : values()) {
            if (e.order.equals(order)) {
                return e;
            }
        }
        return null;
    }

}
