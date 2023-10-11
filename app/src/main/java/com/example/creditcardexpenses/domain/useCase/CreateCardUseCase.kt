package com.example.creditcardexpenses.domain.useCase

import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import com.example.creditcardexpenses.domain.repository.CardsRepository

class CreateCardUseCase(private var repository: CardsRepository)
{
    suspend operator fun invoke(cardEntity: cardEntity) = repository.create(cardEntity = cardEntity)

}