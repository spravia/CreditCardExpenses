package com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component

sealed class CurrencyList(val currency: String, val symbol : String)
{
    object Colones : CurrencyList("CRC", "₡")
    object Dollar : CurrencyList("USD","$")

}
