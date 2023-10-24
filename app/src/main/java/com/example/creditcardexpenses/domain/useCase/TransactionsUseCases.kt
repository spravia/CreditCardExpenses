package com.example.creditcardexpenses.domain.useCase

import com.example.creditcardexpenses.domain.useCase.TransactionUseCases.DeleteTransactionByIdUseCase
import com.example.creditcardexpenses.domain.useCase.TransactionUseCases.DeleteTransactionsByCardIdUseCase
import com.example.creditcardexpenses.domain.useCase.TransactionUseCases.GetTransactionByIdUseCase
import com.example.creditcardexpenses.domain.useCase.TransactionUseCases.GetTransactionsByCardIdUseCase
import com.example.creditcardexpenses.domain.useCase.TransactionUseCases.InsertTransactionUseCase
import com.example.creditcardexpenses.domain.useCase.TransactionUseCases.UpdateTransactionUseCase

data class TransactionsUseCases(
    val getTransactionsByCardId: GetTransactionsByCardIdUseCase,
    val getTransactionById: GetTransactionByIdUseCase,
    val deleteTransactionsByCardId: DeleteTransactionsByCardIdUseCase,
    val deleteTransactionById: DeleteTransactionByIdUseCase,
    val updateTransaction: UpdateTransactionUseCase,
    val insertTransaction: InsertTransactionUseCase
)
