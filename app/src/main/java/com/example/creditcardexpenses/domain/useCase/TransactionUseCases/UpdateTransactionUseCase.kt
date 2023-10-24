package com.example.creditcardexpenses.domain.useCase.TransactionUseCases

import com.example.creditcardexpenses.domain.repository.TransactionsRepository

class UpdateTransactionUseCase (private val repository: TransactionsRepository)
{
    suspend operator fun invoke(id:Int, storename: String, trxcurrency :String, trxamount : Double)
         = repository.updateTransaction(id = id, storename = storename, trxcurrency= trxcurrency, trxamount= trxamount)
}