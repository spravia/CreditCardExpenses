package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CardTransactionDetail(description :String)
{

    Card(modifier = Modifier.padding(start = 2.dp, end = 2.dp)
        , colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp)
    )
    {
        Row(modifier = Modifier
            .padding(start = 25.dp, top = 10.dp)
            .fillMaxWidth())
        {

            Column(modifier = Modifier
                .padding()
            )
            {
                Text(text = description, fontWeight = FontWeight.Bold)
                Text(text = "Sun, 15 Dic")
            }

            Spacer(modifier = Modifier.width(140.dp))

            Column(modifier = Modifier
                .padding()
            )
            {
                Text(text = "$ 500.00",fontWeight = FontWeight.Bold)

            }

            IconButton(onClick = {  } , modifier = Modifier.padding(start = 20.dp).size(20.dp) )
            {
                Icon(Icons.Default.MoreVert, contentDescription = "")
            }

        }
    }


}