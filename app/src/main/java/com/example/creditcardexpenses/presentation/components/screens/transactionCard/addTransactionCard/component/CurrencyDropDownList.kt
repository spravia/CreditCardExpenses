package com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//TODO https://www.youtube.com/watch?v=mJiPQx9483M

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CurrencyDropDownList()
{

    val brandList = listOf("CRC", "USD")
    var expanded by remember { mutableStateOf(false) }
    var selected by remember {  mutableStateOf("") }

    ExposedDropdownMenuBox(
                           expanded = expanded,
                           onExpandedChange = {expanded=!expanded} ,
                           modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, bottom = 20.dp))
    {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = selected,
                onValueChange = {} ,
                label = { Text(text = "Pick a currency")},
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                readOnly = true,
                )

            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false },
                         modifier = Modifier.fillMaxWidth())
            {

                brandList.forEach { item ->

                  DropdownMenuItem(
                      text = { Text(text = item) },
                      contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,  //TODO darle todo el espacio a los items
                      onClick = {
                                selected = item
                                expanded = false
                      }
                  )
                }
            }
    }
}