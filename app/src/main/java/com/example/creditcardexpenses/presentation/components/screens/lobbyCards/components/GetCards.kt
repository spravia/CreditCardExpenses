package com.example.creditcardexpenses.presentation.components.screens.lobbyCards.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.domain.model.CardsModel
import com.example.creditcardexpenses.presentation.components.screens.lobbyCards.LobbyCardsViewModel

@Composable
fun GetCards(navController: NavHostController, paddingValues: PaddingValues,vm: LobbyCardsViewModel = hiltViewModel()){

    val data = vm.cardsResponse

    if (data != null) {
        LobbyCardsContent(navController = navController, paddingValues = paddingValues , cards = data)
    }else{
        CircleProgressBar()
    }
}