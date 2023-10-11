package com.example.creditcardexpenses.presentation.components.screens.addCard.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.creditcardexpenses.R
import com.example.creditcardexpenses.presentation.components.screens.addCard.AddCardViewModel

   //TODO https://www.youtube.com/watch?v=mJiPQx9483M

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DropDownList(vm: AddCardViewModel = hiltViewModel())
{

    val brandList = listOf("Visa", "American Express","Mastercard")
    var expanded by remember { mutableStateOf(false) }
    var selected by remember {  mutableStateOf(brandList[0]) }

    ExposedDropdownMenuBox(
                           expanded = expanded,
                           onExpandedChange = {expanded=!expanded} ,
                           modifier = Modifier.fillMaxWidth())
    {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = selected, onValueChange = {} ,
                label = { Text(text = "Pick a brand")},
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
                      leadingIcon = {

                          when(item){
                              "Visa" ->
                                  Image(
                                      modifier = Modifier
                                          .width(25.dp)
                                          .height(25.dp)
                                          .padding(),
                                      painter = painterResource(id = R.mipmap.simpleiconsvisa),
                                      contentDescription = "")

                              "American Express" ->
                                  Image(
                                      modifier = Modifier
                                          .width(25.dp)
                                          .height(25.dp)
                                          .padding(),
                                      painter = painterResource(id = R.mipmap.fontistoamericanexpress),
                                      contentDescription = "")
                              "Mastercard" ->
                                  Image(
                                  modifier = Modifier
                                      .width(25.dp)
                                      .height(25.dp)
                                      .padding(),
                                  painter = painterResource(id = R.mipmap.logosmastercard),
                                  contentDescription = "")
                          }
                      },
                      onClick = {
                                selected = item
                                expanded = false
                                vm.onBrand(item)
                      }
                  )
                }
            }
    }
}


@Preview
@Composable
fun PreviewDropDownList(){

    DropDownList()

}