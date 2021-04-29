package ru.netology.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }

    public static String getFirstCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static String getFirstCardExpectedStatus() {
        return "APPROVED";
    }

    public static String getSecondCardNumber() {
        return "4444 4444 4444 4442";
    }

    public static String getSecondCardExpectedStatus() {
        return "DECLINED";
    }

    public static String getCardNumberDifferent() {
        return faker.business().creditCardNumber();
    }

    public static String getCardNumberEmpty() {
        return "                   ";
    }

    public static String getCardNumberZero() {
        return "0000 0000 0000 0000";
    }

    public static String getValidMonth() {
        return "01";
    }

    public static String getInvalidMonth() {
        return "13";
    }

    public static String getEmptyMonth() {
        return "  ";
    }

    public static String getZeroMonth() {
        return "00";
    }

    public static String getValidYear() {
        return "24";
    }

    public static String getInvalidYear() {
        return "14";
    }

    public static String getEmptyYear() {
        return "  ";
    }

    public static String getValidOwner() {
        return faker.name().fullName();
    }

    public static String getInvalidOwner() {
        return "Петр(. 123";
    }

    public static String getEmptyOwner() {
        return "  ";
    }

    public static String getLongOwner() {
        return "Владимир Ленин Владимир Ленин Владимир Ленин Владимир Ленин Владимир Ленин Владимир Ленин Владимир Ленин Владимир Ленин Владимир Ленин Владимир Ленин Владимир Ленин";
    }

    public static String getValidCvs() {
        return "456";
    }

    public static String getInvalidCvs() {
        return "12";
    }

    public static String getEmptyCvs() {
        return "  ";
    }

    public static String getZeroCvs() {
        return "000";
    }
}
