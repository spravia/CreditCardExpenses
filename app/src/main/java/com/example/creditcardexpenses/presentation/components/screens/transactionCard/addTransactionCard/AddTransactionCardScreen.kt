package com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component.AddTransactionCardContent

@Composable
fun AddTransactionCardScreen(navController: NavHostController, idCard:String){

    AddTransactionCardContent(navController)


}