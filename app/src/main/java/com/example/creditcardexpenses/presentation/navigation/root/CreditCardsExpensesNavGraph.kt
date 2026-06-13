package com.example.creditcardexpenses.presentation.navigation.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import com.example.creditcardexpenses.presentation.navigation.graph.Graph
import com.example.creditcardexpenses.presentation.navigation.graph.creditCardsNavGraph
import com.example.creditcardexpenses.presentation.navigation.graph.transactionCardNavGraph
import com.example.creditcardexpenses.presentation.navigation.graph.welcomeNavGraph


@Composable
fun CreditCardsExpensesNavGraph(navController: NavHostController){

     NavHost(navController = navController,
             route = Graph.ROOT_CREDIT_CARDS ,
             startDestination = Graph.WELCOME ){

            welcomeNavGraph(navController)
            creditCardsNavGraph(navController)
            transactionCardNavGraph(navController)
     }
}