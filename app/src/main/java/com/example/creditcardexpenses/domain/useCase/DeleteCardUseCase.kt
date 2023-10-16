package com.example.creditcardexpenses.domain.useCase

import com.example.creditcardexpenses.domain.repository.CardsRepository

class DeleteCardUseCase(private val repository: CardsRepository)
{
    suspend operator fun invoke(id:Int) = repository.delete(id = id)

}