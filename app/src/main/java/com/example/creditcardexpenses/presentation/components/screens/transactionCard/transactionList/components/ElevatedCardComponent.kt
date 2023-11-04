package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component.CurrencyList
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.TansactionListViewModel
import com.example.creditcardexpenses.presentation.components.screens.ui.theme.Color10
import java.text.DecimalFormat

@Composable
fun ElevatedCardComponent(vm: TansactionListViewModel)
{

    val format = DecimalFormat("#.00")

    ElevatedCard(modifier = Modifier
        .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 10.dp)
        .height(60.dp)
        .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(Color10)
    )
    {
        Row(modifier = Modifier.padding( end = 5.dp, top = 5.dp))
        {

            Column(modifier = Modifier
                .padding()
                .weight(1f) , horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(text = "Dollar Balance" , fontSize = 15.sp , color= Color.Black)
                Text(text = "${CurrencyList.Dollar.currency} ${format.format(vm.totalBalance.DollarBalance)}", fontWeight = FontWeight.Bold, color= Color.Black )
            }
            Column(modifier = Modifier
                .padding()
                .weight(1f), horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(text = "Local Balance" ,  fontSize = 15.sp , color= Color.Black )
                Text(text = "${CurrencyList.Colones.currency} ${format.format(vm.totalBalance.LocalBalance)}", fontWeight = FontWeight.Bold , color= Color.Black )
            }

        }

    }
}