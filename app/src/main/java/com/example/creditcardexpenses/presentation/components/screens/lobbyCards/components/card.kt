package com.example.creditcardexpenses.presentation.components.screens.lobbyCards.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.R
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


    Card(
        onClick = {
            if (runClick == true) {
                navController.navigate(route = CreditCardsScreens.TransactionDetail.passIdCard(idCard ?: ""))
            }
        },
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
    ) {
        val gradientColors = when (marca) {
            CardBrands.VISA.brand -> listOf(Color(0xFF1A237E), Color(0xFF0D47A1))
            CardBrands.AMERICAN_EXPRESS.brand -> listOf(Color(0xFF546E7A), Color(0xFF263238))
            CardBrands.MASTER_CARD.brand -> listOf(Color(0xFFBF360C), Color(0xFF3E2723))
            else -> listOf(Color(0xFF2C3E50), Color(0xFF000000))
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = Brush.linearGradient(colors = gradientColors))
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    when (marca) {
                        CardBrands.VISA.brand ->
                            Image(
                                painter = painterResource(id = R.mipmap.simpleiconsvisa),
                                contentDescription = "Visa",
                                modifier = Modifier.height(35.dp).width(65.dp)
                            )
                        CardBrands.AMERICAN_EXPRESS.brand ->
                            Image(
                                painter = painterResource(id = R.mipmap.fontistoamericanexpress),
                                contentDescription = "Amex",
                                modifier = Modifier.height(35.dp).width(65.dp)
                            )
                        CardBrands.MASTER_CARD.brand ->
                            Image(
                                painter = painterResource(id = R.mipmap.logosmastercard),
                                contentDescription = "Mastercard",
                                modifier = Modifier.height(35.dp).width(65.dp)
                            )
                        else -> {
                            Text(
                                text = "CARD",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Image(
                        painter = painterResource(id = R.mipmap.contactless),
                        contentDescription = "Contactless",
                        modifier = Modifier.size(24.dp),
                        alpha = 0.7f
                    )
                }

                // Chip placeholder
                Surface(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .size(width = 40.dp, height = 28.dp),
                    color = Color(0xFFFFD700).copy(alpha = 0.8f),
                    shape = RoundedCornerShape(4.dp)
                ) {}

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = if (cardNumber.isNullOrEmpty()) "**** **** **** ****" else "**** **** **** $cardNumber",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = cardName ?: "Card Holder",
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1f).padding(bottom = 4.dp)
                    )

                    if (!valid.isNullOrEmpty()) {
                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "VALID THRU",
                                color = Color.White.copy(alpha = 0.7f),
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = valid,
                                color = Color.White,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }

}


@Composable
fun previewCard(){

    //card("1345")

}