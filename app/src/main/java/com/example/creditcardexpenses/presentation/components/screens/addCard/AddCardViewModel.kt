package com.example.creditcardexpenses.presentation.components.screens.addCard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import com.example.creditcardexpenses.domain.useCase.CardsUseCases
import com.example.creditcardexpenses.domain.useCase.CreateCardUseCase
import com.example.creditcardexpenses.domain.useCase.GetCardsUseCase
import com.example.creditcardexpenses.presentation.components.screens.addCard.components.CardData
import com.example.creditcardexpenses.presentation.components.screens.util.CardBrands
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddCardViewModel @Inject constructor(private val cardsUseCases: CardsUseCases) : ViewModel()
{

    var state by mutableStateOf(CardData())
        private set

    var errorMessage by mutableStateOf("")

    var brand by mutableStateOf("")
        private set


    fun saveCard() = viewModelScope.launch {

        if(isValidForm()){
            cardsUseCases.createCardUseCase(cardEntity = cardEntity(id =0,"","",0,0))
        }
    }

    fun isValidForm() : Boolean{

            return true

    }



    fun onAlias(alias : String){
        state = state.copy(alias=alias)
    }

    fun onLastFourDigits(cardNumber : String){

        if(cardNumber.length > 4) state = state.copy(cardNumber = cardNumber.substring(0,4)) else state = state.copy(cardNumber = cardNumber)
    }

    fun onValidThru(onValidThru : String)
    {
        if(onValidThru.length == 2)
        {
            state = state.copy(validThru = onValidThru + "/")
        } else if(onValidThru.length > 5)
        {
            state = state.copy(validThru = onValidThru.substring(0,4))
        } else state = state.copy(validThru = onValidThru)

    }

    fun onBrand(input : String){

        brand = input

        when(input) {
            "Visa" -> state = state.copy(marca = CardBrands.VISA)
            "Mastercard" -> state = state.copy(marca = CardBrands.MASTER_CARD)
            "American Express" -> state = state.copy(marca = CardBrands.AMERICAN_EXPRESS)
        }
    }
}