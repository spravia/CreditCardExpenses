package com.example.creditcardexpenses.presentation.components.screens.lobbyCards.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.presentation.components.screens.lobbyCards.LobbyCardsViewModel

@Composable
fun GetCards(navController: NavHostController, paddingValues: PaddingValues,vm: LobbyCardsViewModel = hiltViewModel()){

    val data = vm.cardsResponse

    if (data != null) {
        LobbyCardsContent(navController = navController, paddingValues = paddingValues , cards = data)
    }

}