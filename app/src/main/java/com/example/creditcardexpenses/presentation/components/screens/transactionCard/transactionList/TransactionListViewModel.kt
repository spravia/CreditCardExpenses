package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.creditcardexpenses.domain.model.CardsModel
import com.example.creditcardexpenses.domain.useCase.CardsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TansactionListViewModel @Inject constructor(
    private val useCases: CardsUseCases,
    private val savedStateHandle: SavedStateHandle

     ) : ViewModel()
{

   val idCard = savedStateHandle.get<String>("idCard")

   var cardData by mutableStateOf<CardsModel?>(null)
       private set

   var errorMessage by mutableStateOf("")

   init {
        getCardById()
   }

    private fun getCardById () = viewModelScope.launch {

        cardData = useCases.getCardById(idCard!!.toInt())

    }

    fun deleteCard() = viewModelScope.launch {

        try {
            useCases.deleteCard(idCard!!.toInt())
            errorMessage = "Card deleted"
        }finally {  }
    }

}