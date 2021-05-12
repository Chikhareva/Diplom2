package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.DatabaseHelper;
import ru.netology.page.Main;
import ru.netology.page.Payment;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyByCreditCardTest {
    Main main = new Main();
    Payment payment = new Payment();

    @BeforeEach
    void shouldCleanDataBaseAndOpenWeb() {
        DatabaseHelper.cleanDataBase();
        open("http://localhost:8080", Main.class);
        main.buyWithCredit();

    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldPayFirstCardApprove() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.expectApprovalFromBank();
        val expected = DataHelper.getFirstCardExpectedStatus();
        val actual = DatabaseHelper.getStatusPaymentWithCredit();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPaymentBySecondCardReject() {
        val cardNumber = DataHelper.getSecondCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.expectRejectionFromBank();
        val expected = DataHelper.getSecondCardExpectedStatus();
        val actual = DatabaseHelper.getStatusPaymentWithCredit();
        assertEquals(expected, actual);
    }
}
