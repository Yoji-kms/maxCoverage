package ru.netology

import kotlin.math.max
import kotlin.math.roundToInt

fun main() {
    val prevTransactionAmount = 30_000.0
    val paymentType = PaymentType.MASTERCARD
    val currentTransactionAmount = 45_568.15

    val commission: Double = commissionPennies(
        paymentType = paymentType,
        prevTransactionAmount = prevTransactionAmount,
        currentTransactionAmount = currentTransactionAmount
    ).toDouble() / 100
    println("Commission: $commission")
}

fun commissionPennies(
    paymentType: PaymentType = PaymentType.VK_PAY,
    prevTransactionAmount: Double = 0.0,
    currentTransactionAmount: Double
): Int {
    val maestroMaxFreeTransaction = 75_000
    val maestroCommissionPercent = 0.006
    val maestroAdditionalCommission = 20
    val visaCommissionPercent = 0.0075
    val visaMinCommission = 35

    return when (paymentType) {
        PaymentType.VK_PAY -> 0
        PaymentType.MAESTRO, PaymentType.MASTERCARD ->
            if (prevTransactionAmount + currentTransactionAmount < maestroMaxFreeTransaction) 0
            else ((currentTransactionAmount * maestroCommissionPercent + maestroAdditionalCommission) * 100).roundToInt()
        PaymentType.MIR, PaymentType.VISA ->
            max(visaMinCommission * 100, (currentTransactionAmount * visaCommissionPercent * 100).roundToInt())
    }
}
