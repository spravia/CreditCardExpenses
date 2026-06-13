package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        BalanceItem(
            modifier = Modifier.weight(1f),
            label = "Dollar Balance",
            amount = "${CurrencyList.Dollar.currency} ${format.format(vm.totalBalance.DollarBalance)}",
            containerColor = Color(0xFFE8EAF6),
            contentColor = Color(0xFF3F51B5)
        )
        BalanceItem(
            modifier = Modifier.weight(1f),
            label = "Local Balance",
            amount = "${CurrencyList.Colones.currency} ${format.format(vm.totalBalance.LocalBalance)}",
            containerColor = Color(0xFFE8F5E9),
            contentColor = Color(0xFF4CAF50)
        )
    }
}

@Composable
fun BalanceItem(
    modifier: Modifier = Modifier,
    label: String,
    amount: String,
    containerColor: Color,
    contentColor: Color
) {
    ElevatedCard(
        modifier = modifier.height(80.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = label,
                fontSize = 12.sp,
                color = contentColor.copy(alpha = 0.8f),
                fontWeight = FontWeight.Medium
            )
            Text(
                text = amount,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
        }
    }
}
