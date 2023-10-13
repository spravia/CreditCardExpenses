package com.example.creditcardexpenses.domain.useCase

data class CardsUseCases(
     val getCardsUseCase :GetCardsUseCase,
     var createCardUseCase: CreateCardUseCase,
     var getCardById : GetCardByIdUseCase
)
