package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.creditcardexpenses.presentation.components.screens.ui.theme.Gray

@Composable
fun CardTransaction()
{

    Card(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        colors = CardDefaults.cardColors(containerColor = Gray)
    )
    {

        Text(modifier = Modifier
            .padding(top = 5.dp)
            .padding(horizontal = 140.dp),
            text = "Transactions", fontSize = 17.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        val descriptions = listOf("Netflix","Amazon","Apple Bill","Netflix","Amazon","Apple Bill","Netflix","Amazon","Apple Bill","Netflix","Amazon","Apple Bill")

        LazyColumn( )
        {
            items(items = descriptions)
            {
               transactionDetail ->  CardTransactionDetail(description = transactionDetail)
            }
        }
    }

}