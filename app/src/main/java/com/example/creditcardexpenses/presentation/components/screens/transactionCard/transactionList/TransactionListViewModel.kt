package com.example.creditcardexpenses.presentation.components.screens.transactionCard.transactionList

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.creditcardexpenses.domain.model.CardsModel
import com.example.creditcardexpenses.domain.model.TransactionsModel
import com.example.creditcardexpenses.domain.useCase.CardsUseCases
import com.example.creditcardexpenses.domain.useCase.TransactionsUseCases
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component.CurrencyList
import com.example.creditcardexpenses.presentation.components.screens.transactionCard.addTransactionCard.component.TotalBalance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TansactionListViewModel @Inject constructor(
    private val useCases: CardsUseCases,
    private val trxUseCases: TransactionsUseCases,
    private val savedStateHandle: SavedStateHandle

     ) : ViewModel()
{

   val idCard = savedStateHandle.get<String>("idCard")

   var transactionList by mutableStateOf<List<TransactionsModel>?>(null)

   var totalBalance by mutableStateOf(TotalBalance(DollarBalance = .00, LocalBalance = .00))

   var cardData by mutableStateOf<CardsModel?>(null)
       private set

   var errorMessage by mutableStateOf("")

   init {
       getTransactionsListByCardId()
   }

    private fun getTransactionsListByCardId () = viewModelScope.launch {

        cardData = useCases.getCardById(idCard!!.toInt())

        trxUseCases.getTransactionsByCardId(cardId = cardData!!.id).collect()
        { it ->
            transactionList = it

            if (transactionList !=null) {

                transactionList?.forEach() {
                    when (it.trxcurrency)
                    {
                        CurrencyList.Dollar.currency -> {
                            totalBalance.DollarBalance =
                                totalBalance.DollarBalance.plus(it.trxamount)
                        }
                        CurrencyList.Colones.currency -> {
                            totalBalance.LocalBalance =
                                totalBalance.LocalBalance.plus(it.trxamount)
                        }
                    }
                }
            }

            Log.d("getCardById","$transactionList")
        }
    }

    fun deleteCard() = viewModelScope.launch {

        try {
            useCases.deleteCard(idCard!!.toInt())
            errorMessage = "Card deleted"
        }finally {  }
    }

}