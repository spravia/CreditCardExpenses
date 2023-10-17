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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.creditcardexpenses.presentation.components.screens.ui.theme.Color10

@Composable
fun ElevatedCardComponent()
{

    ElevatedCard(modifier = Modifier
        .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 10.dp)
        .height(60.dp)
        .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(Color10)
    )
    {
        Row(modifier = Modifier.padding(start = 25.dp, end = 5.dp, top = 5.dp))
        {

            Column(modifier = Modifier
                .padding()
                .fillMaxHeight() , horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(text = "Dollar Balance" , fontSize = 15.sp)
                Text(text = "$ 5000.00", fontWeight = FontWeight.Bold )
            }
            Column(modifier = Modifier
                .padding(start = 115.dp)
                .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(text = "Local Balance" ,  fontSize = 15.sp  )
                Text(text = "₡ 5000.00", fontWeight = FontWeight.Bold  )
            }

        }

    }
}