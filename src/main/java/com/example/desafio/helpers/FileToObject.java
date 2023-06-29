package com.example.desafio.helpers;

import com.example.desafio.enums.NatureTransactionEnum;
import com.example.desafio.enums.SignalTransactionEnum;
import com.example.desafio.enums.TypeTransactionEnum;
import com.example.desafio.model.FileTransaction;
import com.example.desafio.model.TypeTransaction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FileToObject {

    public static FileTransaction mapToObject(String s) {
        FileTransaction fileTransaction = new FileTransaction();

        fileTransaction.setTypeTransaction(getTypeTransaction(s));
        fileTransaction.setDateTransaction(getLocalDate(s));
        fileTransaction.setValueTransaction(getBigDecimal(s));
        fileTransaction.setCpf(s.substring(19, 30));
        fileTransaction.setCardNumber(s.substring(30, 42));
        fileTransaction.setHourTransaction(getHourTransaction(s));
        fileTransaction.setStoreOwner(s.substring(48, 62));
        fileTransaction.setStoreName(s.substring(62, 80));

        return fileTransaction;
    }

    private static TypeTransaction getTypeTransaction(String s) {
        TypeTransaction typeTransaction = new TypeTransaction();
        String type = s.substring(0, 1);
        typeTransaction.setTypeTransaction(TypeTransactionEnum.valueOfLabel(type));
        if (type.equals("2") || type.equals("3") || type.equals("9")) {
            typeTransaction.setNatureTransaction(NatureTransactionEnum.SAIDA);
            typeTransaction.setSignalTransaction(SignalTransactionEnum.NEGATIVE);
        } else {
            typeTransaction.setNatureTransaction(NatureTransactionEnum.ENTRADA);
            typeTransaction.setSignalTransaction(SignalTransactionEnum.POSITIVE);
        }
        return typeTransaction;
    }

    private static LocalTime getHourTransaction(String s) {
        String timePattern = "hh:mm:ss";
        DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(timePattern);
        int hour = Integer.parseInt(s.substring(42, 44));
        int minute = Integer.parseInt(s.substring(44, 46));
        int second = Integer.parseInt(s.substring(46, 48));
        LocalTime time = LocalTime.of(hour, minute, second);
        timeColonFormatter.format(time);
        return time;
    }

    private static LocalDate getLocalDate(String s) {
        return LocalDate.parse(s.substring(1, 9), DateTimeFormatter.BASIC_ISO_DATE);
    }

    private static BigDecimal getBigDecimal(String s) {
        BigDecimal valueTransaction = new BigDecimal(s.substring(9, 19));
        BigDecimal hundred = new BigDecimal(100);
        valueTransaction = valueTransaction.divide(hundred, RoundingMode.CEILING);
        return valueTransaction;
    }
}
