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

public class BuyTravelWithoutCreditCartTest {
    Main main = new Main();
    Payment payment = new Payment();

    @BeforeEach
    void shouldOpenWeb() {
        DatabaseHelper.cleanDataBase();
        open("http://localhost:8080", Main.class);
        main.buyWithoutCredit();

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
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.expectApprovalFromBank();
        val expected = DataHelper.getApprovedCardExpectedStatus();
        val actual = DatabaseHelper.getStatusPaymentWithoutCredit();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPaymentBySecondCardReject() {
        val cardNumber = DataHelper.getDeclidedCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.expectRejectionFromBank();
        val expected = DataHelper.getDeclidedCardExpectedStatus();
        val actual = DatabaseHelper.getStatusPaymentWithoutCredit();
        assertEquals(expected, actual);

    }

    @Test
    void shouldPaymentDifferentCardReject() {
        val cardNumber = DataHelper.getCardNumberDifferent();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.expectRejectionFromBank();
    }

    @Test
    void shouldRejectWhenPayCardWithEmptyNumber() {
        val cardNumber = DataHelper.getEmptyCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitInvalidFormat();
    }

    @Test
    void shouldRejectWhenPayCardWithZeroNumber() {
        val cardNumber = DataHelper.getZeroCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitInvalidFormat();
    }


    @Test
    void shouldRejectWhenPayCarWithEmptyCvs() {
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsEmpty();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitInvalidFormat();
    }

    @Test
    void shouldRejectWhenPayCarWithInvalidCvs() {
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsInvalid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitInvalidFormat();
    }

    @Test
    void shouldRejectWhenPayCarWithZeroCvs() {
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsZero();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitInvalidFormat();
    }


    @Test
    void shouldRejectEmptyMonth() {
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitInvalidFormat();
    }

    @Test
    void shouldRejectWhenPayCarWithInvalidMonth() {
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonthInvalid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitInvalidDuration();
    }

    @Test
    void shouldRejectWhenPayCarWithZeroMonth() {
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonthZero();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitInvalidDuration();
    }

    @Test
    void shouldRejectWhenPayCarWithEmptyYear() {
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearEmpty();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitInvalidFormat();
    }

    @Test
    void shouldRejectWhenPayCarWithInvalidYear() {
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearInvalid();
        val owner = DataHelper.getOwnerValid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitInvalidYear();
    }

    @Test
    void shouldRejectWhenPayCarWithEmptyOwner() {
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerEmpty();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitNecessaryFillOutField();
    }

    @Test
    void shouldRejectWhenPayCarWithInvalidOwner() {
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerInvalid();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitInvalidFormat();
    }

    @Test
    void shouldRejectWhenPayCarWithLongOwner() {
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonthValid();
        val year = DataHelper.getYearValid();
        val owner = DataHelper.getOwnerLong();
        val cvs = DataHelper.getCvsValid();
        payment.fillOutFields(cardNumber, month, year, owner, cvs);
        payment.waitInvalidFormat();
    }

}

