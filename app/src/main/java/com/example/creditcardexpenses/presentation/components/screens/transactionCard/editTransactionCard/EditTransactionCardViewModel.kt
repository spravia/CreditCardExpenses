package com.example.creditcardexpenses.presentation.components.screens.transactionCard.editTransactionCard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
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
import javax.inject.Inject

@HiltViewModel
class EditTransactionCardViewModel @Inject constructor (
    private val transactionUseCases: TransactionsUseCases,
    private val cardUseCases: CardsUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel()
{
   var cardData by mutableStateOf<CardsModel?>(null)
       private set

   var errorMessage by mutableStateOf("")

   val idTrx = savedStateHandle.get<String>("idTrx")

    var transactionsModel by mutableStateOf( TransactionsModel(id = 0, storename = "", trxcurrency = "", cardId = 0, trxamount = 0.0, trxdate = ""))
        private set

    var amountTrx by mutableStateOf("")

    init {
        getTransactionById()
    }

    fun getTransactionById() = viewModelScope.launch {
        if (idTrx != null) {
            val trx = transactionUseCases.getTransactionById(idTrx.toInt())
            transactionsModel = trx
            amountTrx = trx.trxamount.toString()
            getCardById(trx.cardId)
        }
    }

    private fun getCardById(cardId: Int) = viewModelScope.launch {
        cardData = cardUseCases.getCardById(cardId)
    }

    fun updateTransaction() : Boolean
    {
        return if (allDataFormIsValid()) {
            viewModelScope.launch {
                transactionUseCases.updateTransaction(
                    id = transactionsModel.id,
                    storename = transactionsModel.storename,
                    trxcurrency = transactionsModel.trxcurrency,
                    trxamount = transactionsModel.trxamount
                )
                errorMessage = "Transaction updated"
            }
            true
        } else false
    }

    private fun allDataFormIsValid() : Boolean
    {
        if(transactionsModel.storename == "") {
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
        transactionsModel = transactionsModel.copy(trxcurrency = input)
    }

    fun validIntputTrxAmount(input : String){
        try {
            transactionsModel = transactionsModel.copy(trxamount = input.toDouble())
            amountTrx = input
        } catch (_ : Exception) { }
    }
}
