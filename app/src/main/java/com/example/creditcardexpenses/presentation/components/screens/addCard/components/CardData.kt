package com.example.creditcardexpenses.presentation.components.screens.addCard.components

import com.example.creditcardexpenses.presentation.components.screens.util.CardBrands

data class CardData(
     var cardNumber : String = "" ,
     var marca : CardBrands? = CardBrands.NONE_CARD,
     var alias :String ="",
     var validThru : String = "",
)
