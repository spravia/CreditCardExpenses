package com.example.creditcardexpenses.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.creditcardexpenses.presentation.components.screens.addCard.AddCardScreen
import com.example.creditcardexpenses.presentation.components.screens.lobbyCards.ShowCards
import com.example.creditcardexpenses.presentation.navigation.screen.CreditCardsScreens

fun NavGraphBuilder.creditCardsNavGraph(navController: NavHostController){

    navigation(route = Graph.LOBBY_CREDIT_CARDS, startDestination = CreditCardsScreens.Lobby_Cards.route)
    {
      composable(route=CreditCardsScreens.Lobby_Cards.route)
      {
          ShowCards(navController = navController)
      }

        composable(route=CreditCardsScreens.AddNew_Cards.route)
        {
            AddCardScreen(navController=navController)
        }
    }
}