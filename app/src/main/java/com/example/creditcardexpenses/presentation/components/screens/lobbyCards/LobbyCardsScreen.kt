package com.example.creditcardexpenses.presentation.components.screens.lobbyCards


import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import com.example.creditcardexpenses.presentation.components.screens.lobbyCards.components.GetCards
import com.example.creditcardexpenses.presentation.components.screens.lobbyCards.components.LobbyCardsContent
import com.example.creditcardexpenses.presentation.components.screens.ui.theme.PurpleGrey80
import com.example.creditcardexpenses.presentation.navigation.screen.CreditCardsScreens


@Composable
fun ShowCards(navController: NavHostController){

    Scaffold(

       floatingActionButton = {
           ExtendedFloatingActionButton(
               text = {  Text(text = "Add") },
               onClick = {  navController.navigate(route = CreditCardsScreens.AddNew_Cards.route ) },
               icon ={ Icon(Icons.Filled.Add,"")},
               backgroundColor = PurpleGrey80
           )
       }
    )
    { paddingValues ->

        GetCards(navController = navController, paddingValues = paddingValues)

    }
}