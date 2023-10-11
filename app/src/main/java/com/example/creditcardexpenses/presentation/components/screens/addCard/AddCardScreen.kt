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

@Composable
fun AddCardScreen(navController: NavHostController, vm: AddCardViewModel = hiltViewModel()){

    Scaffold(

        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {  Text(text = "Save") },
                onClick = { vm.saveCard()  },
                icon ={ Icon(Icons.Filled.Add,"") },
                backgroundColor = PurpleGrey80
            )
        }
    )
    { paddingValues ->
        AddCardContent(navController=navController , paddingValues=paddingValues)
    }
}