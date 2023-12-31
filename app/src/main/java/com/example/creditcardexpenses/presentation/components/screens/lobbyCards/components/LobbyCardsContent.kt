package com.example.creditcardexpenses.presentation.components.screens.lobbyCards.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.domain.model.CardsModel

@Composable
fun LobbyCardsContent(navController: NavHostController,  paddingValues:PaddingValues , cards :List<CardsModel> )
{

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()
        .background(Color.DarkGray)) {

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
               card(
                    idCard = it.id.toString(),
                    cardNumber = it.fourDigits.toString(),
                    cardName = it.alias,
                    marca = it.brand,
                    valid = it.validThru.toString(),
                    runClick = true,
                    navController = navController
               )
            }
        }
    }
}