package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.components.TransactionListContent

@Composable
fun TransactionListScreen(navController: NavHostController, string: String?){
    
    TransactionListContent(navController= navController)

}