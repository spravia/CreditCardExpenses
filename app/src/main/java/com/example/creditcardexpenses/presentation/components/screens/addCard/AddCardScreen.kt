package com.example.creditcardexpenses.presentation.components.screens.addCard

import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.presentation.components.screens.addCard.components.AddCardContent
import com.example.creditcardexpenses.presentation.components.screens.ui.theme.PurpleGrey80
import com.example.creditcardexpenses.presentation.navigation.graph.Graph
import com.example.creditcardexpenses.presentation.navigation.screen.CreditCardsScreens

@Composable
fun AddCardScreen(navController: NavHostController, vm: AddCardViewModel = hiltViewModel()){

    Scaffold(

        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {  Text(text = "Save") },
                onClick = { vm.saveCard()
                            navController.navigate(route = Graph.LOBBY_CREDIT_CARDS)
                               {
                                   popUpTo(CreditCardsScreens.AddNew_Cards.route) {inclusive=true}
                               }
                          },
                icon ={ Icon(Icons.Filled.Add,"") },
                backgroundColor = PurpleGrey80
            )
        }
    )
    { paddingValues ->
        AddCardContent(navController=navController , paddingValues=paddingValues)
    }
}