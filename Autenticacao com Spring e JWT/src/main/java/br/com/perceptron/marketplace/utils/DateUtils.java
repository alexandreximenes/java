package br.com.perceptron.marketplace.utils;

import br.com.perceptron.marketplace.response.ResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static br.com.perceptron.marketplace.response.ResponseUtils.$400;

public class DateUtils {
    private static ResponseDTO<DateUtils> responseVO = new ResponseDTO<>();

    public static String toBR() {
        return format(LocalDateTime.now());
    }

    public static String getDefaultBR() {
        return format(LocalDateTime.now());
    }

    public static String getDefaultBR(LocalDateTime localDateTime) {
        return format(localDateTime);
    }

    public static String format(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(localDateTime);
    }

    public static LocalDateTime getToSQL() {
        return LocalDateTime.now();
    }

    public static LocalDateTime getToSQL(String date) {
        LocalDateTime dateTime = null;
        try {
            dateTime = LocalDateTime.parse(date);
        } catch (Exception e) {
            responseVO.error($400, "Não foi possivel converter data", DateUtils.class, "getToSQL", e);
        }

        return dateTime;
    }

    public static LocalDate addDias(int dias) {
        return LocalDate.now().plus(dias, ChronoUnit.DAYS);
    }

    public static LocalDate addMeses(int meses) {
        return LocalDate.now().plus(meses, ChronoUnit.MONTHS);
    }

    public static LocalDate hoje() {
        return LocalDate.now();
    }

    public static String toBR(LocalDateTime data) {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(data);
    }
}
