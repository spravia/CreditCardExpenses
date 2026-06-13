package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.domain.model.TransactionsModel
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component.CurrencyList
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.TansactionListViewModel
import com.example.creditcardexpenses.presentation.navigation.screen.CreditCardsScreens
import java.text.DecimalFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CardTransactionDetail(
    transactionsModel: TransactionsModel,
    navController: NavHostController,
    vm: TansactionListViewModel = hiltViewModel()
)
{

    val format = DecimalFormat("#.00")
    var extended by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFBFBFB)),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Transaction Icon Placeholder
            Surface(
                modifier = Modifier.size(44.dp),
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFFF0F0F0)
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier.padding(10.dp),
                    tint = Color(0xFF616161)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                val (mes, dia) = convertDate(transactionsModel.trxdate.substring(0, 8))

                Text(
                    text = transactionsModel.storename.trimEnd(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = "${dia}, ${transactionsModel.trxdate.substring(6, 8)} ${mes}",
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                val color = if (transactionsModel.trxcurrency == CurrencyList.Dollar.currency) Color(0xFFD32F2F) else Color(0xFF1976D2)

                Text(
                    text = "${if (transactionsModel.trxcurrency == CurrencyList.Dollar.currency) CurrencyList.Dollar.symbol else CurrencyList.Colones.symbol} ${format.format(transactionsModel.trxamount)}",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp,
                    color = color
                )
            }

            IconButton(onClick = { extended = true }, modifier = Modifier.size(24.dp))
            {
                Icon(Icons.Default.MoreVert, contentDescription = "", tint = Color.LightGray)
            }

            DropdownMenu(expanded = extended, onDismissRequest = { extended = false }
            )
            {
                DropdownMenuItem(
                    text = { Text(text = "Edit") },
                    onClick = {
                        extended = false
                        navController.navigate(CreditCardsScreens.EditTransactionCard.passIdTrx(transactionsModel.id.toString()))
                    },
                    leadingIcon = { Icon(Icons.Default.Edit, contentDescription = "", tint = Color.Black) }
                )

                DropdownMenuItem(
                    text = { Text(text = "Delete") },
                    onClick = {
                                vm.deleteTransactionById(transactionsModel.id)
                              },
                    leadingIcon = { Icon(Icons.Default.Delete, contentDescription = "", tint = Color.Black) }
                )
            }

        }
    }
}


@SuppressLint("SuspiciousIndentation")
private fun convertDate(date : String) : Pair<String, String>
{

    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")

    return try {
        val fecha = LocalDate.parse(date, formatter)
        val month = fecha.month.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
            .substring(0,3)
        val day = fecha.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
            .substring(0,3)
        Pair(month, day)
    }catch (_ : Exception){
        Pair("Unknown","Unknown")
    }
}