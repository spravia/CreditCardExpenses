package com.example.creditcardexpenses.presentation.navigation.screen

sealed class CreditCardsScreens(val route :String){

     object Lobby_Cards : CreditCardsScreens("lobby_cards")

     object AddNew_Cards : CreditCardsScreens("addnew_cards")

}
