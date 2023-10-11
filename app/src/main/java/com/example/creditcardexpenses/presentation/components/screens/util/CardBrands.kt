package com.example.creditcardexpenses.presentation.components.screens.util

sealed class CardBrands(val brand: String){

    object VISA : CardBrands("VSA")

    object AMERICAN_EXPRESS : CardBrands("AMX")

    object MASTER_CARD : CardBrands("MSC")

    object NONE_CARD : CardBrands("")

}


