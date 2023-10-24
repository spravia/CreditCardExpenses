package com.example.creditcardexpenses.domain.useCase.TransactionUseCases

import com.example.creditcardexpenses.data.dataSource.local.entity.TransactionEntity
import com.example.creditcardexpenses.domain.repository.TransactionsRepository

class InsertTransactionUseCase (private val repository: TransactionsRepository)
{
     suspend operator fun invoke(transactionEntity: TransactionEntity) = repository.createTransaction(transactionEntity = transactionEntity)
}