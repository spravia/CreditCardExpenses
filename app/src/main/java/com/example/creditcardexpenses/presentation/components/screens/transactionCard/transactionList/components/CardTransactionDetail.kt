package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.components

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
import androidx.compose.ui.unit.dp
import com.example.creditcardexpenses.domain.model.TransactionsModel
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component.CurrencyList
import java.text.DecimalFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CardTransactionDetail(transactionsModel: TransactionsModel)
{

    val format = DecimalFormat("#.00")
    var extended by remember { mutableStateOf(false) }

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
                .weight(2f)
            )
            {
               val(mes, dia) = convertDate(transactionsModel.trxdate.substring(0,8))

                Text(text = transactionsModel.storename.trimEnd(), fontWeight = FontWeight.Bold)
                Text(text = "${dia}, ${transactionsModel.trxdate.substring(6,8)} ${mes}")
            }

            Column(modifier = Modifier
                .padding()
                .weight(1f)
            )
            {
                val color = if (transactionsModel.trxcurrency == CurrencyList.Dollar.currency) Color.Red else Color.Blue

                Text(text = "${if (transactionsModel.trxcurrency == CurrencyList.Dollar.currency) CurrencyList.Dollar.symbol else CurrencyList.Colones.symbol} ${ format.format(transactionsModel.trxamount)}",
                     fontWeight = FontWeight.Bold, color = color)

            }

            IconButton(onClick = { extended = true } , modifier = Modifier
                .padding(start = 20.dp)
                .size(20.dp) )
            {
                Icon(Icons.Default.MoreVert, contentDescription = "")
            }

            DropdownMenu(expanded = extended, onDismissRequest = { extended = false }
            )
            {
                DropdownMenuItem(
                    text = { Text(text = "Edit") },
                    onClick = { extended = false },
                    leadingIcon = { Icon(Icons.Default.Edit, contentDescription = "") }
                )

                DropdownMenuItem(
                    text = { Text(text = "Delete") },
                    onClick = {


                              },
                    leadingIcon = { Icon(Icons.Default.Delete, contentDescription = "") }
                )
            }

        }
    }
}


private fun convertDate(date : String) : Pair<String, String>
{

    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")

        try {
            val fecha = LocalDate.parse(date, formatter)
            val month = fecha.month.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
                .substring(0,3)
            val day = fecha.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
                .substring(0,3)
            return Pair(month, day)
        }catch (_ : Exception){
            return Pair("Unknown","Unknown")
        }
}