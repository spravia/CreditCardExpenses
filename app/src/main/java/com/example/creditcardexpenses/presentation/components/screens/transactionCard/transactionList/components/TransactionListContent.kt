package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList.TansactionListViewModel
import com.example.creditcardexpenses.presentation.navigation.graph.Graph

@Composable
fun TransactionListContent(navController: NavHostController,
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

                Card(modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp, top = 10.dp, bottom = 10.dp)
                    .height(130.dp)
                    .fillMaxWidth(),
                     elevation = CardDefaults.elevatedCardElevation(),
                     shape = RoundedCornerShape(10.dp)
                )
                {

                   Row(modifier = Modifier.padding(), horizontalArrangement = Arrangement.SpaceBetween)
                   {
                       Column(modifier = Modifier.padding(), horizontalAlignment = Alignment.Start)
                       {
                           Text(text = "${vm.cardData?.alias}",
                               modifier = Modifier.padding(start = 15.dp, top = 20.dp),
                               fontSize = 15.sp,
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

                       Column(modifier = Modifier.padding())
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
                                   onClick = { /*TODO*/ },
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
        }

   }

}