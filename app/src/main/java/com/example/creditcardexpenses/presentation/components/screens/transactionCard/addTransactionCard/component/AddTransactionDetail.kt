package com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.AddTransactionCardViewModel
import com.example.creditcardexpenses.presentation.components.screens.ui.theme.Gray
import com.example.creditcardexpenses.presentation.navigation.screen.CreditCardsScreens

@Composable
fun AddTransactionDetail( navController: NavHostController, vm : AddTransactionCardViewModel)
{
    val state = vm.transactionsModel

    Card(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp, bottom = 20.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp, bottomEnd = 40.dp, bottomStart = 40.dp),
        colors = CardDefaults.cardColors(containerColor = Gray)
    )
    {

        Column(
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
        )
        {


            Text(modifier = Modifier
                .padding(top = 5.dp, bottom = 35.dp)
                .padding(horizontal = 80.dp),
                text = "Enter Transaction Detail", fontSize = 17.sp
            )

            OutlinedTextField(
                value = state.storename,
                onValueChange = { vm.validIntputStoreName(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, bottom = 20.dp),
                label = { Text(text = "Store Name") }
            )

            CurrencyDropDownList(vm)

            OutlinedTextField(
                value = state.trxamount.toString(),
                onValueChange = { vm.validIntputTrxAmount(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, bottom = 50.dp),
                label = { Text(text = "Amount") }
            )

            ElevatedButton(onClick = {
                                       vm.saveTransaction()
                                       navController.navigate(route = CreditCardsScreens.TransactionDetail.passIdCard(vm.cardIdTrx ?: ""))
                                     } ,
                           modifier = Modifier.padding(16.dp)
            )
            {
                Text(text = "Save")
            }
        }
    }

}