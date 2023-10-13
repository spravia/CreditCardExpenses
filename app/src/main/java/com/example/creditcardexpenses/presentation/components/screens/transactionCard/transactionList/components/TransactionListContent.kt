package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.TansactionListViewModel

@Composable
fun TransactionListContent(navController: NavHostController,
                           vm: TansactionListViewModel = hiltViewModel(),

)
{

    Text(text = vm.cardData?.id.toString())

}