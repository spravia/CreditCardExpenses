package com.example.creditcardexpenses.domain.useCase.TransactionUseCases

import com.example.creditcardexpenses.domain.repository.TransactionsRepository

class GetTransactionsByCardIdUseCase(private val repository: TransactionsRepository)
{
    operator fun invoke(cardId: Int) = repository.findAllTransactionsByCardId(cardId= cardId)

}