package com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.AddTransactionCardViewModel
import com.example.creditcardexpenses.presentation.components.screens.ui.theme.Color10

@Composable
fun AddTransactionCardContent(vm : AddTransactionCardViewModel = hiltViewModel())
{

      Box(modifier = Modifier
            .fillMaxSize()
            .padding())
      {

            Column(modifier = Modifier.padding())
            {

                  ElevatedCard(modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
                        .height(130.dp)
                        .fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                        colors = CardDefaults.cardColors(Color10)
                  )
                  {

                        Row(modifier = Modifier.padding())
                        {
                              Column(modifier = Modifier
                                    .padding()
                                    .fillMaxHeight(), horizontalAlignment = Alignment.Start)
                              {
                                    Text(text = "${vm.cardData?.alias}",
                                          modifier = Modifier.padding(start = 15.dp, top = 20.dp),
                                          fontSize = 25.sp,
                                          fontWeight = FontWeight.Light,
                                          color = Color.Black
                                    )

                                    Text(text = "****-****-****-${vm.cardData?.fourDigits}",
                                          modifier = Modifier.padding(start = 15.dp),
                                          fontSize = 20.sp,
                                          fontWeight = FontWeight.Bold,
                                          color = Color.Black
                                    )
                              }

                        }
                  }

                  AddTransactionDetail(vm)

            }
      }


}