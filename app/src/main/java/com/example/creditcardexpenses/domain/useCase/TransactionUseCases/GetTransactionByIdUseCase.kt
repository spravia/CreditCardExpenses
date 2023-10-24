package com.example.creditcardexpenses.domain.useCase.TransactionUseCases

import com.example.creditcardexpenses.domain.repository.TransactionsRepository

class GetTransactionByIdUseCase(private val repository: TransactionsRepository)
{
    suspend operator fun invoke(id:Int) = repository.findTransactionById(id = id)

}