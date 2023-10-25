package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.components.TransactionListContent
import com.example.creditcardexpenses.presentation.components.screens.ui.theme.PurpleGrey80
import com.example.creditcardexpenses.presentation.navigation.screen.CreditCardsScreens

@Composable
fun TransactionListScreen(navController: NavHostController, cardId: String){


    Scaffold(modifier = Modifier,
             floatingActionButton =
             {
                  ExtendedFloatingActionButton(
                        text = {  Text(text = "Add Trx") },
                        onClick = {
                                    navController.navigate(route = CreditCardsScreens.AddTransactionCard.passIdCard(cardId))
                                  },
                        icon ={ Icon(Icons.Filled.Add,"") },
                        backgroundColor = PurpleGrey80
                  )
             }
    )
    { paddingValues ->

        TransactionListContent( paddingValues = paddingValues , navController= navController)

    }

}