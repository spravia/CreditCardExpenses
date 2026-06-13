package com.example.creditcardexpenses.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.creditcardexpenses.presentation.components.screens.welcome.WelcomeScreen
import com.example.creditcardexpenses.presentation.navigation.screen.CreditCardsScreens

fun NavGraphBuilder.welcomeNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.WELCOME,
        startDestination = CreditCardsScreens.Welcome.route
    ) {
        composable(route = CreditCardsScreens.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
    }
}
