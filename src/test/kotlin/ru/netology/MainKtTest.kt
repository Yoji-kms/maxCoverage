package ru.netology

import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    @Test
    fun main_mastercard_moreThen75000() {
        val prevTransactionAmount = 30_000.0
        val paymentType = PaymentType.MASTERCARD
        val currentTransactionAmount = 45_568.15

        val commission: Double = commissionPennies(
            paymentType = paymentType,
            prevTransactionAmount = prevTransactionAmount,
            currentTransactionAmount = currentTransactionAmount
        ).toDouble() / 100

        assertEquals(293.41, commission, 0.0)
    }

    @Test
    fun main_mastercard_lessThen75000() {
        val prevTransactionAmount = 30_000.0
        val paymentType = PaymentType.MASTERCARD
        val currentTransactionAmount = 15_568.15

        val commission: Double = commissionPennies(
            paymentType = paymentType,
            prevTransactionAmount = prevTransactionAmount,
            currentTransactionAmount = currentTransactionAmount
        ).toDouble() / 100

        assertEquals(0.0, commission, 0.0)
    }

    @Test
    fun main_vkPay() {
        val prevTransactionAmount = 30_000.0
        val paymentType = PaymentType.VK_PAY
        val currentTransactionAmount = 15_568.15

        val commission: Double = commissionPennies(
            paymentType = paymentType,
            prevTransactionAmount = prevTransactionAmount,
            currentTransactionAmount = currentTransactionAmount
        ).toDouble() / 100

        assertEquals(0.0, commission, 0.0)
    }

    @Test
    fun main_visa_commissionMin() {
        val prevTransactionAmount = 30_000.0
        val paymentType = PaymentType.VISA
        val currentTransactionAmount = 4_568.15

        val commission: Double = commissionPennies(
            paymentType = paymentType,
            prevTransactionAmount = prevTransactionAmount,
            currentTransactionAmount = currentTransactionAmount
        ).toDouble() / 100


        assertEquals(35.0, commission, 0.0)
    }

    @Test
    fun main_visa_commissionPercent() {
        val prevTransactionAmount = 30_000.0
        val paymentType = PaymentType.VISA
        val currentTransactionAmount = 15_568.15

        val commission: Double = commissionPennies(
            paymentType = paymentType,
            prevTransactionAmount = prevTransactionAmount,
            currentTransactionAmount = currentTransactionAmount
        ).toDouble() / 100


        assertEquals(116.76, commission, 0.0)
    }
}