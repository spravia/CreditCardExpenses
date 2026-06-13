package com.example.creditcardexpenses.presentation.components.screens.addCard.components


import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.creditcardexpenses.presentation.components.screens.addCard.AddCardViewModel
import com.example.creditcardexpenses.presentation.components.screens.lobbyCards.components.card

@Composable
fun AddCardContent(navController: NavHostController,  paddingValues: PaddingValues,
              vm : AddCardViewModel = hiltViewModel())
{

    val state = vm.state
    val context = LocalContext.current
    var visible by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = vm.errorMessage){
       if(vm.errorMessage != ""){
           Toast.makeText(context, vm.errorMessage, Toast.LENGTH_SHORT).show()
           vm.errorMessage = ""
       }
    }


    AnimatedVisibility(
        visible = visible,
        enter =  fadeIn(initialAlpha = 0.3f),
        exit = fadeOut()

    ) {

        Box(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize()
                .background(Color(0xFFF8F9FA))
        )
        {
            Column(modifier = Modifier.padding(16.dp)) {
                card(
                    idCard = "",
                    cardNumber = state.cardNumber,
                    cardName = state.alias,
                    marca = state.marca?.brand,
                    valid = state.validThru,
                    navController = navController
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
            )
            {
                Spacer(modifier = Modifier.weight(1f))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
                )
                {
                    Column(
                        modifier = Modifier
                            .padding(24.dp)
                            .verticalScroll(rememberScrollState())
                    )
                    {
                        Text(
                            text = "Card Information",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 24.dp)
                        )

                        Text(
                            text = "Card Brand",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        DropDownList()

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = state.alias,
                            onValueChange = { vm.onAlias(it) },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = "Card Alias") },
                            placeholder = { Text(text = "e.g. Personal Visa") },
                            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = Color(0xFF6200EE)) },
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF6200EE),
                                focusedLabelColor = Color(0xFF6200EE),
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = state.cardNumber,
                            onValueChange = { vm.onLastFourDigits(it) },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = "Last 4 Digits") },
                            placeholder = { Text(text = "0000") },
                            leadingIcon = { Icon(Icons.Default.Info, contentDescription = null, tint = Color(0xFF6200EE)) },
                            shape = RoundedCornerShape(12.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF6200EE),
                                focusedLabelColor = Color(0xFF6200EE),
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = state.validThru,
                            onValueChange = { vm.onValidThru(it) },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = "Expiry Date") },
                            placeholder = { Text(text = "MM/YY") },
                            leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = null, tint = Color(0xFF6200EE)) },
                            shape = RoundedCornerShape(12.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF6200EE),
                                focusedLabelColor = Color(0xFF6200EE),
                            )
                        )

                        Spacer(modifier = Modifier.height(32.dp))
                    }
                }
            }
        }
    }
}



@Preview
@Composable
fun PreviewAddCardContent()
{
     val paddingValues  = PaddingValues(all = 0.dp)
     val navController : NavHostController = rememberNavController()

     AddCardContent(navController = navController , paddingValues = paddingValues)

}