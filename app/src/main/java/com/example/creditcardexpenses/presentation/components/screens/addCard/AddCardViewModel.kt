package com.example.creditcardexpenses.presentation.components.screens.addCard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import com.example.creditcardexpenses.domain.model.CardsModel
import com.example.creditcardexpenses.domain.useCase.CardsUseCases
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

    var data = CardsModel(0,"","",0,0)

    fun saveCard() = viewModelScope.launch {

        if(isValidForm()){

            cardsUseCases.createCardUseCase(cardEntity = cardEntity().apply
               {
                 id = data.id
                 alias = data.alias
                 brand = data.brand
                 fourDigits = data.fourDigits
                 validThru = data.validThru
                }

            )
            errorMessage = "Card saved"
        }
    }

    fun isValidForm() : Boolean{


        if(state.marca==null){
            errorMessage = "Please pick a brand"
            return false
        }else{
            when(state.marca)
            {
               CardBrands.MASTER_CARD -> data.brand  = CardBrands.MASTER_CARD.brand
               CardBrands.VISA        -> data.brand  = CardBrands.VISA.brand
               CardBrands.AMERICAN_EXPRESS -> data.brand = CardBrands.AMERICAN_EXPRESS.brand
               else -> { return false }
            }
        }

        if(state.alias == "")
        {
            errorMessage = "Please digit the alias card"
            return false
        } else data.alias = state.alias

        if(state.cardNumber.length < 4)
        {
            errorMessage = "Please digit las four digit"
            return false
        } else data.fourDigits = state.cardNumber.toInt()


    if(state.validThru == "" || state.validThru.length < 4 || !state.validThru.isDigitsOnly())
        {
            errorMessage = "Please digit valid thru"
            return false
        }else
        {
            data.validThru = state.validThru.substring(0,4).toInt()
        }

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
        if(onValidThru.length > 4)
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