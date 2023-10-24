package com.example.creditcardexpenses.domain.useCase.TransactionUseCases

import com.example.creditcardexpenses.domain.repository.TransactionsRepository

class DeleteTransactionByIdUseCase(private val repository: TransactionsRepository)
{
    suspend operator fun invoke(id:Int) = repository.deleteTransactionById(id = id)
}