package com.example.creditcardexpenses.domain.useCase.CardUseCases

import com.example.creditcardexpenses.domain.repository.CardsRepository

class GetCardsUseCase(private val repository: CardsRepository) {
        operator fun invoke() = repository.findAll()

}