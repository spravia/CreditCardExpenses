package com.example.creditcardexpenses.domain.useCase.CardUseCases

import com.example.creditcardexpenses.domain.repository.CardsRepository

class GetCardByIdUseCase(private var repository: CardsRepository) {

    suspend operator fun  invoke(id:Int) = repository.findCardById(id)

}