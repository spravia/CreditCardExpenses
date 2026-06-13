package com.example.creditcardexpenses.presentation.components.screens.addCard.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    var selected by remember { mutableStateOf(brandList[0]) }

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
            label = { Text(text = "Brand") },
            placeholder = { Text(text = "Select card brand") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            leadingIcon = { Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFF6200EE)) },
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
                    leadingIcon = {
                        when(item){
                            "Visa" ->
                                Image(
                                    modifier = Modifier.size(24.dp),
                                    painter = painterResource(id = R.mipmap.simpleiconsvisa),
                                    contentDescription = "")
                            "American Express" ->
                                Image(
                                    modifier = Modifier.size(24.dp),
                                    painter = painterResource(id = R.mipmap.fontistoamericanexpress),
                                    contentDescription = "")
                            "Mastercard" ->
                                Image(
                                    modifier = Modifier.size(24.dp),
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