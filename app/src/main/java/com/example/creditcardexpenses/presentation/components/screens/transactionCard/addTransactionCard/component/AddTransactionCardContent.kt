package com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.AddTransactionCardViewModel

@Composable
fun AddTransactionCardContent(navController: NavHostController ,vm : AddTransactionCardViewModel = hiltViewModel())
{
      val context = LocalContext.current

      LaunchedEffect(key1 = vm.errorMessage){
            if(vm.errorMessage != ""){
                  Toast.makeText(context, vm.errorMessage, Toast.LENGTH_SHORT).show()
                  vm.errorMessage = ""
            }
      }

      Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA))
            .padding())
      {

            Column(modifier = Modifier.padding())
            {

                  ElevatedCard(
                        modifier = Modifier
                              .padding(16.dp)
                              .height(180.dp)
                              .fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                        shape = RoundedCornerShape(16.dp)
                  ) {
                        Box(
                              modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                          brush = Brush.linearGradient(
                                                colors = listOf(Color(0xFF2C3E50), Color(0xFF000000))
                                          )
                                    )
                                    .padding(24.dp)
                        ) {
                              Column {
                                    Row(
                                          modifier = Modifier.fillMaxWidth(),
                                          horizontalArrangement = Arrangement.SpaceBetween,
                                          verticalAlignment = Alignment.Top
                                    ) {
                                          Text(
                                                text = vm.cardData?.brand?.uppercase() ?: "CARD",
                                                color = Color.White,
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.ExtraBold
                                          )
                                    }

                                    // Chip placeholder
                                    Surface(
                                          modifier = Modifier
                                                .padding(vertical = 8.dp)
                                                .size(width = 40.dp, height = 28.dp),
                                          color = Color(0xFFFFD700).copy(alpha = 0.7f),
                                          shape = RoundedCornerShape(4.dp)
                                    ) {}

                                    Spacer(modifier = Modifier.weight(1f))

                                    Text(
                                          text = "**** **** **** ${vm.cardData?.fourDigits}",
                                          color = Color.White,
                                          fontSize = 22.sp,
                                          fontWeight = FontWeight.SemiBold
                                    )

                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                          text = vm.cardData?.alias ?: "",
                                          color = Color.White.copy(alpha = 0.7f),
                                          fontSize = 14.sp,
                                          fontWeight = FontWeight.Normal
                                    )
                              }
                        }
                  }

                  AddTransactionDetail( navController, vm)

            }
      }


}