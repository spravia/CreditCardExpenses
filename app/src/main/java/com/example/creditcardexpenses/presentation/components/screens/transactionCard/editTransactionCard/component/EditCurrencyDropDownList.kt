package com.example.creditcardexpenses.presentation.components.screens.transactionCard.editTransactionCard.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component.CurrencyList
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.editTransactionCard.EditTransactionCardViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun EditCurrencyDropDownList(vm : EditTransactionCardViewModel)
{
    val brandList = listOf(CurrencyList.Dollar.currency, CurrencyList.Colones.currency)
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(vm.transactionsModel.trxcurrency) }

    // Update selected when ViewModel changes (e.g. after loading)
    LaunchedEffect(vm.transactionsModel.trxcurrency) {
        selected = vm.transactionsModel.trxcurrency
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier.fillMaxWidth()
    )
    {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = selected,
            onValueChange = {},
            label = { Text(text = "Currency") },
            placeholder = { Text(text = "Select currency") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            leadingIcon = { Icon(Icons.Default.Info, contentDescription = null, tint = Color(0xFF6200EE)) },
            readOnly = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF6200EE),
                focusedLabelColor = Color(0xFF6200EE),
            )
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        {
            brandList.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        selected = item
                        expanded = false
                        vm.validCurrencyInput(item)
                    }
                )
            }
        }
    }
}
