package com.example.creditcardexpenses.domain.useCase

import com.example.creditcardexpenses.domain.repository.CardsRepository

class GetCardsUseCase(private val repository: CardsRepository) {
        operator fun invoke() = repository.findAll()

}