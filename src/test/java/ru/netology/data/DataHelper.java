package ru.netology.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }

    public static String getApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static String getApprovedCardExpectedStatus() {
        return "APPROVED";
    }

    public static String getDeclidedCardNumber() {
        return "4444 4444 4444 4442";
    }

    public static String getDeclidedCardExpectedStatus() {
        return "DECLINED";
    }

    public static String getCardNumberDifferent() {
        return faker.business().creditCardNumber();
    }

    public static String getEmptyCardNumber() {
        return "                   ";
    }

    public static String getZeroCardNumber() {
        return "0000 0000 0000 0000";
    }

    public static String getMonthEmpty() {
        return "  ";
    }

    public static String getMonthZero() {
        return "00";
    }

    public static String getMonthValid() {
        return "03";
    }

    public static String getMonthInvalid() {
        return "13";
    }

    public static String getYearEmpty() {
        return "  ";
    }

    public static String getYearValid() {
        return "23";
    }

    public static String getYearInvalid() {
        return "09";
    }

    public static String getOwnerValid() {
        return faker.name().fullName();
    }

    public static String getOwnerInvalid() {
        return "Васька=)812";
    }

    public static String getOwnerEmpty() {
        return "  ";
    }

    public static String getOwnerLong() {
        return "Маша Иванова Петрова Сидорова Сергеевааааааааааа Маша Иванова Иванова";
    }

    public static String getCvsValid() {
        return "874";
    }

    public static String getCvsInvalid() {
        return "15";
    }

    public static String getCvsEmpty() {
        return "  ";
    }

    public static String getCvsZero() {
        return "000";
    }
}
