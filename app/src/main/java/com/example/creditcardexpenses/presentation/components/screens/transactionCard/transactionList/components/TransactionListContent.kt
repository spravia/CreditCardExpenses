package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.TansactionListViewModel
import com.example.creditcardexpenses.presentation.components.screens.ui.theme.Color10
import com.example.creditcardexpenses.presentation.navigation.graph.Graph

@Composable
fun TransactionListContent( paddingValues: PaddingValues,
                           navController: NavHostController,
                           vm: TansactionListViewModel = hiltViewModel(),

)
{

   var extended by remember { mutableStateOf(false) }

   val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage){
        if(vm.errorMessage != ""){
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_SHORT).show()
            vm.errorMessage = ""
        }
    }

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

                       Column(modifier = Modifier
                           .padding()
                           .fillMaxHeight()
                           .fillMaxWidth())
                       {
                           IconButton(onClick = { extended = true } , modifier = Modifier.padding(start = 115.dp, top = 70.dp) )
                           {
                               Icon(Icons.Default.MoreVert, contentDescription = "")
                           }

                           DropdownMenu(expanded = extended,
                                        onDismissRequest = { extended = false }
                           )
                           {
                               androidx.compose.material3.DropdownMenuItem(
                                   text = { Text(text = "Edit") },
                                   onClick = { extended = false },
                                   leadingIcon = { Icon(Icons.Default.Edit, contentDescription = "") }
                               )

                               androidx.compose.material3.DropdownMenuItem(
                                   text = { Text(text = "Delete") },
                                   onClick = {
                                       vm.deleteCard()
                                       navController.navigate(route = Graph.LOBBY_CREDIT_CARDS)
                                             },
                                   leadingIcon = { Icon(Icons.Default.Delete, contentDescription = "") }
                               )
                           }
                       }

                   }
                }

                ElevatedCardComponent()

                Spacer(modifier = Modifier.height(20.dp))

                CardTransaction()
        }
   }

}