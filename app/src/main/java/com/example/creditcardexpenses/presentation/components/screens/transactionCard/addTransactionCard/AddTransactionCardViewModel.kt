package com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.creditcardexpenses.domain.model.CardsModel
import com.example.creditcardexpenses.domain.model.TransactionsModel
import com.example.creditcardexpenses.domain.useCase.CardsUseCases
import com.example.creditcardexpenses.domain.useCase.TransactionsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTransactionCardViewModel @Inject constructor (
    private val transactionUseCases: TransactionsUseCases,
    private val cardUseCases: CardsUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel()
{
   var cardData by mutableStateOf<CardsModel?>(null)
       private set

   val cardIdTrx = savedStateHandle.get<String>("idCardTrx")


    var transactionsModel by mutableStateOf( TransactionsModel(id = 0, storename = "", trxcurrency = "", cardId = 0, trxamount = 0.00, trxdate = 0))
        private set


    init {
        getCardById()
    }

    fun getCardById() = viewModelScope.launch {

        if (cardIdTrx != null) {
            cardData = cardUseCases.getCardById(cardIdTrx.toInt())
            transactionsModel?.id = cardIdTrx.toInt()
        }
    }


    fun validIntputStoreName(input : String){
        transactionsModel = transactionsModel.copy(storename = input)
    }


    fun validIntputTrxAmount(input : String){


        try {

            transactionsModel = transactionsModel.copy(trxamount = input.toDouble())

        }catch (_ : Exception){


        }

    }

}