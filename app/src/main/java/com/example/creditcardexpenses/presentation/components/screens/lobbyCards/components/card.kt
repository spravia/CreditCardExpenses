package com.example.creditcardexpenses.presentation.components.screens.lobbyCards.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.R
import com.example.creditcardexpenses.presentation.components.screens.ui.theme.Blue
import com.example.creditcardexpenses.presentation.components.screens.util.CardBrands
import com.example.creditcardexpenses.presentation.navigation.screen.CreditCardsScreens


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun card(
    idCard     : String? = "",
    cardNumber : String?     ,
    cardName   : String?     ,
    marca      : String? = CardBrands.NONE_CARD.brand ,
    valid      : String?,
    runClick   : Boolean?  = false,
    navController: NavHostController
) {


    androidx.compose.material.Card(
        onClick = {
            if (runClick == true)
            {
                navController.navigate(route = CreditCardsScreens.TransactionDetail.passIdCard(idCard ?: ""))
            }
        },
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp),
        //backgroundColor = Purple40
    ) {


    val color =  if(marca == null || marca == CardBrands.AMERICAN_EXPRESS.brand) Color.Gray else Blue

    Row( modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient
                (
                colors = listOf(color, Color.White)
            )
        ))
    {

        Column(modifier = Modifier.padding())
        {

            Row(horizontalArrangement = Arrangement.SpaceBetween)
            {
                when (marca) {
                    CardBrands.VISA.brand ->
                        Image(
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)
                                .padding(start = 20.dp),
                            painter = painterResource(id = R.mipmap.simpleiconsvisa),
                            contentDescription = ""
                        )

                    CardBrands.MASTER_CARD.brand ->
                        Image(
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)
                                .padding(start = 20.dp),
                            painter = painterResource(id = R.mipmap.logosmastercard),
                            contentDescription = ""
                        )

                    CardBrands.AMERICAN_EXPRESS.brand ->
                        Image(
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)
                                .padding(start = 20.dp),
                            painter = painterResource(id = R.mipmap.fontistoamericanexpress),
                            contentDescription = ""
                        )

                    else -> {}
                }

                Image(
                    modifier = Modifier
                        .padding(top = 20.dp, start = 140.dp)
                        .width(30.dp)
                        .height(30.dp),
                    painter = painterResource(id = R.mipmap.contactless), contentDescription = ""
                )
            }


            Column(modifier = Modifier.padding(top = 30.dp))
            {


                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    text = cardName ?: "",
                    color = Color.Black
                )


                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "****-****-****-${cardNumber ?: ""}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Text(
                    text = "Valid Thru: ${valid ?: ""}",
                    modifier = Modifier.padding(start = 130.dp),
                    color = Color.Black,
                    fontSize = 10.sp,

                )

            }

        }

    }

    }

}

@Preview
@Composable
fun previewCard(){

    //card("1345")

}