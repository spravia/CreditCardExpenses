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
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
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
import com.example.creditcardexpenses.presentation.components.screens.ui.theme.Blue2

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
                .background(Blue2)
        )
        {

            Column(modifier = Modifier.padding(top = 30.dp)) {
                card(
                    cardNumber = state.cardNumber,
                    cardName = state.alias,
                    marca = state.marca,
                    valid = state.validThru
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding()
            )
            {

                Spacer(modifier = Modifier.weight(1f))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
                {

                    Column(
                        modifier = Modifier
                            .padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 15.dp)
                            .verticalScroll(rememberScrollState())
                    )
                    {

                        Text(
                            modifier = Modifier.padding(bottom = 10.dp),
                            text = "Please type card data",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )

                        DropDownList()

                        OutlinedTextField(
                            value = state.alias,
                            onValueChange = { vm.onAlias(it) },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = "Alias Card") }
                        )


                        OutlinedTextField(
                            value = state.cardNumber,
                            onValueChange = { vm.onLastFourDigits(it) },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = "Last four digits") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )

                        OutlinedTextField(
                            value = state.validThru,
                            onValueChange = { vm.onValidThru(it) },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text(text = "Expiration Date") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )


                        Spacer(modifier = Modifier.height(100.dp))
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