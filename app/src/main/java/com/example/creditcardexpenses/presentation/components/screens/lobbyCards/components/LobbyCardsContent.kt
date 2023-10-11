package com.example.creditcardexpenses.presentation.components.screens.lobbyCards.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.presentation.components.screens.lobbyCards.LobbyCardsViewModel
import com.example.creditcardexpenses.presentation.components.screens.util.CardBrands

@Composable
fun LobbyCardsContent(navController: NavHostController,  paddingValues:PaddingValues, vm: LobbyCardsViewModel = hiltViewModel()){

    val cards = listOf<String>("9999", "1934","7895","1541","7951")

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .height(750.dp)) {

        LazyColumn(
            modifier = Modifier.padding(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp,
                bottom = 55.dp
            )
        )
        {
            items(items = cards)
            {
                card(it,cardName = "VISA", marca = CardBrands.MASTER_CARD,valid = "4/26")
            }
        }
    }
}