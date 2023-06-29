package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun mastercardIsDailyLimitExceeded() {
        val cardType = "Mastercard"
        val previousTransfers = 20_000
        val amount = 160_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(ERROR_DAILY_LIMIT_EXCEEDED, result, 0.01)
    }

    @Test
    fun maestroIsDailyLimitExceeded() {
        val cardType = "Maestro"
        val previousTransfers = 20_000
        val amount = 170_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(ERROR_DAILY_LIMIT_EXCEEDED, result, 0.01)
    }

    @Test
    fun visaIsDailyLimitExceeded() {
        val cardType = "Visa"
        val previousTransfers = 20_000
        val amount = 180_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(ERROR_DAILY_LIMIT_EXCEEDED, result, 0.01)
    }

    @Test
    fun mirIsDailyLimitExceeded() {
        val cardType = "Мир"
        val previousTransfers = 20_000
        val amount = 180_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(ERROR_DAILY_LIMIT_EXCEEDED, result, 0.01)
    }

    @Test
    fun vKPayIsDailyLimitExceeded() {
        val cardType = "VK Pay"
        val previousTransfers = 10_000
        val amount = 20_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(ERROR_DAILY_LIMIT_EXCEEDED, result, 0.01)
    }

    @Test
    fun mastercardIsMonthlyLimitExceeded() {
        val cardType = "Mastercard"
        val previousTransfers = 580_000
        val amount = 140_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(ERROR_MONTHLY_LIMIT_EXCEEDED, result, 0.01)
    }

    @Test
    fun maestroIsMonthlyLimitExceeded() {
        val cardType = "Maestro"
        val previousTransfers = 550_000
        val amount = 140_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(ERROR_MONTHLY_LIMIT_EXCEEDED, result, 0.01)
    }

    @Test
    fun visaIsMonthlyLimitExceeded() {
        val cardType = "Visa"
        val previousTransfers = 580_000
        val amount = 140_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(ERROR_MONTHLY_LIMIT_EXCEEDED, result, 0.01)
    }

    @Test
    fun mirIsMonthlyLimitExceeded() {
        val cardType = "Мир"
        val previousTransfers = 580_000
        val amount = 140_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(ERROR_MONTHLY_LIMIT_EXCEEDED, result, 0.01)
    }

    @Test
    fun vKPayIsMonthlyLimitExceeded() {
        val cardType = "VK Pay"
        val previousTransfers = 35_000
        val amount = 10_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(ERROR_MONTHLY_LIMIT_EXCEEDED, result, 0.01)
    }

    @Test
    fun mastercardCommissionBeforeStartCommission() {
        val cardType = "Mastercard"
        val previousTransfers = 10_000
        val amount = 30_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun maestroCommissionBeforeStartCommission() {
        val cardType = "Maestro"
        val previousTransfers = 10_000
        val amount = 40_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun mastercardCommissionAfterStartCommission() {
        val cardType = "Mastercard"
        val previousTransfers = 50_000
        val amount = 50_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(220.0, result, 0.01)
    }

    @Test
    fun maestroCommissionAfterStartCommission() {
        val cardType = "Maestro"
        val previousTransfers = 70_000
        val amount = 10_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(80.0, result, 0.01)
    }

    @Test
    fun visaCommission() {
        val cardType = "Visa"
        val previousTransfers = 5_000
        val amount = 6_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(45.0, result, 0.01)
    }

    @Test
    fun mirCommission() {
        val cardType = "Мир"
        val previousTransfers = 5_000
        val amount = 8_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(60.0, result, 0.01)
    }

    @Test
    fun visaMinimumCommission() {
        val cardType = "Visa"
        val previousTransfers = 10_000
        val amount = 4_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(MINIMUM_COMMISSION, result, 0.01)
    }

    @Test
    fun mirMinimumCommission() {
        val cardType = "Мир"
        val previousTransfers = 10_000
        val amount = 2_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(MINIMUM_COMMISSION, result, 0.01)
    }

    @Test
    fun vKPayCommission() {
        val cardType = "VK Pay"
        val previousTransfers = 20_000
        val amount = 10_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun wrongCardType() {
        val cardType = "UnionPay"
        val previousTransfers = 20_000
        val amount = 10_000

        val result = commission(cardType = cardType, previousTransfers = previousTransfers, amount = amount)
        assertEquals(ERROR_WRONG_CARD_TYPE, result, 0.01)
    }
}
