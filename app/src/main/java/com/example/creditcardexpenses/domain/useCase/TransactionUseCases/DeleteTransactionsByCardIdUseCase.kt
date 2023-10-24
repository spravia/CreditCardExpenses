package com.example.creditcardexpenses.domain.useCase.TransactionUseCases

import com.example.creditcardexpenses.domain.repository.TransactionsRepository

class DeleteTransactionsByCardIdUseCase (private val repository: TransactionsRepository)
{
    suspend operator fun invoke(cardID:Int) = repository.deleteTransactionByCardId(cardId = cardID)

}