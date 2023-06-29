package ru.netology

const val COMMISSION_RATE = 0.0075
const val MINIMUM_COMMISSION = 35.0
const val MAESTRO_COMMISSION_RATE = 0.006
const val START_COMMISSION = 75_000
const val DAILY_LIMIT = 150_000
const val MONTHLY_LIMIT = 600_000
const val VK_PAY_DAILY_LIMIT = 15_000
const val VK_PAY_MONTHLY_LIMIT = 40_000
const val ERROR_WRONG_CARD_TYPE = -1.0
const val ERROR_DAILY_LIMIT_EXCEEDED = -2.0
const val ERROR_MONTHLY_LIMIT_EXCEEDED = -3.0

fun main() {
    val result = commission("Visa", 10_000, 4_000)
    when (result) {
        ERROR_WRONG_CARD_TYPE -> println("Тип карты не поддерживается")
        ERROR_DAILY_LIMIT_EXCEEDED -> println("Превышен лимит переводов в сутки")
        ERROR_MONTHLY_LIMIT_EXCEEDED -> println("Превышен лимит переводов в этом месяце")
        else -> println("Комиссия $result р.")
    }
}

fun commission(cardType: String = "VK Pay", previousTransfers: Int = 0, amount: Int): Double {
    return when (cardType) {
        "Visa", "Мир", "Mastercard", "Maestro" ->
            return when {
                amount > DAILY_LIMIT -> ERROR_DAILY_LIMIT_EXCEEDED
                (amount + previousTransfers) > MONTHLY_LIMIT -> ERROR_MONTHLY_LIMIT_EXCEEDED
                else -> {
                    return when (cardType) {
                        "Visa", "Мир" ->
                            if ((amount * COMMISSION_RATE) >= MINIMUM_COMMISSION) (amount * COMMISSION_RATE)
                            else MINIMUM_COMMISSION

                        else -> {
                            if ((amount + previousTransfers) > START_COMMISSION)
                                (amount * MAESTRO_COMMISSION_RATE) + 20.0
                            else 0.0
                        }
                    }
                }
            }

        "VK Pay" -> {
            when {
                amount > VK_PAY_DAILY_LIMIT -> ERROR_DAILY_LIMIT_EXCEEDED
                ((amount + previousTransfers) > VK_PAY_MONTHLY_LIMIT) -> ERROR_MONTHLY_LIMIT_EXCEEDED
                else -> 0.0
            }
        }

        else -> ERROR_WRONG_CARD_TYPE
    }
}