package com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard

import android.icu.text.DateFormat
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import android.icu.text.SimpleDateFormat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.creditcardexpenses.data.dataSource.local.mapper.toTransactionEntity
import com.example.creditcardexpenses.domain.model.CardsModel
import com.example.creditcardexpenses.domain.model.TransactionsModel
import com.example.creditcardexpenses.domain.useCase.CardsUseCases
import com.example.creditcardexpenses.domain.useCase.TransactionsUseCases
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component.CurrencyList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class AddTransactionCardViewModel @Inject constructor (
    private val transactionUseCases: TransactionsUseCases,
    private val cardUseCases: CardsUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel()
{
   val formato = SimpleDateFormat("yyyyMMddHHmmss")

   var cardData by mutableStateOf<CardsModel?>(null)
       private set

   var errorMessage by mutableStateOf("")

   val cardIdTrx = savedStateHandle.get<String>("idCardTrx")

    var transactionsModel by mutableStateOf( TransactionsModel(id = 0, storename = "", trxcurrency = "", cardId = 0, trxamount = .00, trxdate = ""))
        private set


    init {
        getCardById()
    }

    fun getCardById() = viewModelScope.launch {

        if (cardIdTrx != null) {
            cardData = cardUseCases.getCardById(cardIdTrx.toInt())
            transactionsModel.cardId = cardIdTrx.toInt()
            transactionsModel.trxdate = formato.format(Date())
        }
    }

    fun saveTransaction() = viewModelScope.launch {
        if (allDataFormIsValid())
        {
          transactionUseCases.insertTransaction(transactionsModel.toTransactionEntity() )
          errorMessage = "Transaction added"
        }
    }

    private fun allDataFormIsValid() : Boolean
    {

        if(transactionsModel.storename == "" || transactionsModel.storename == null) {
            errorMessage = "Digit a store name"
            return false
        }

        if(transactionsModel.trxcurrency == "" || (transactionsModel.trxcurrency != CurrencyList.Colones.currency && transactionsModel.trxcurrency != CurrencyList.Dollar.currency))
        {
            errorMessage = "Pick a currency"
            return false
        }

        if(transactionsModel.trxamount <= 0.00){
            errorMessage = "Digit the amount"
            return false
        }

        return true

    }


    fun validIntputStoreName(input : String){
        transactionsModel = transactionsModel.copy(storename = input)
    }

    fun validCurrencyInput(input: String)
    {
        transactionsModel.trxcurrency = input
    }

    fun validIntputTrxAmount(input : String){


        try {

            transactionsModel = transactionsModel.copy(trxamount = input.toDouble())

        }catch (_ : Exception){


        }

    }

}