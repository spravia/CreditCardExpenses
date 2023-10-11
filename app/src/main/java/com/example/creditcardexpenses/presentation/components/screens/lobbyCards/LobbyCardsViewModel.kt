package com.example.creditcardexpenses.presentation.components.screens.lobbyCards

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import com.example.creditcardexpenses.domain.model.CardsModel
import com.example.creditcardexpenses.domain.useCase.CardsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LobbyCardsViewModel @Inject constructor(private val cardsUseCases: CardsUseCases) : ViewModel()
{

    var cardsResponse by mutableStateOf<List<CardsModel>?>(null)

    init {
        getCards()
    }


    fun getCards() = viewModelScope.launch {

       val result = cardsUseCases.getCardsUseCase().collect()
            {
               cardsResponse = it
       }
    }
}