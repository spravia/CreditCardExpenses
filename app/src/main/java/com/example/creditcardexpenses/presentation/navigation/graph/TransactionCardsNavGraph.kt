package com.example.creditcardexpenses.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.AddTransactionCardScreen
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.TransactionListScreen
import com.example.creditcardexpenses.presentation.navigation.screen.CreditCardsScreens

fun NavGraphBuilder.transactionCardNavGraph(navController: NavHostController){

    navigation(route = Graph.TRANSACTION_CARD ,
               startDestination = CreditCardsScreens.TransactionDetail.route)
    {

      composable(route=CreditCardsScreens.TransactionDetail.route,
                 arguments = listOf(navArgument("idCard")
                   {
                      type = NavType.StringType
                   }
                 )
      )
      {
          backStackEntry ->
          backStackEntry.arguments?.getString("idCard")?.let {
              TransactionListScreen(navController = navController,
                  it
              )
          }
      }


      composable(route= CreditCardsScreens.AddTransactionCard.route,
                 arguments = listOf(navArgument("idCardTrx")
                      {  type = NavType.StringType }
                 )
      )
      {
              backStackEntry ->
          backStackEntry.arguments?.getString("idCardTrx")?.let{
              AddTransactionCardScreen(navController = navController, it )
          }
      }
      }
}