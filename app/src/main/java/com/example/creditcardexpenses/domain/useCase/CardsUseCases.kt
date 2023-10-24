package com.example.creditcardexpenses.domain.useCase

import com.example.creditcardexpenses.domain.useCase.CardUseCases.CreateCardUseCase
import com.example.creditcardexpenses.domain.useCase.CardUseCases.DeleteCardUseCase
import com.example.creditcardexpenses.domain.useCase.CardUseCases.GetCardByIdUseCase
import com.example.creditcardexpenses.domain.useCase.CardUseCases.GetCardsUseCase

data class CardsUseCases(
    val getCardsUseCase : GetCardsUseCase,
    var createCardUseCase: CreateCardUseCase,
    var getCardById : GetCardByIdUseCase,
    var deleteCard : DeleteCardUseCase
)
