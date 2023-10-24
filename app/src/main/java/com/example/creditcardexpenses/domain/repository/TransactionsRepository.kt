package com.example.creditcardexpenses.domain.repository

import com.example.creditcardexpenses.data.dataSource.local.entity.TransactionEntity
import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import com.example.creditcardexpenses.domain.model.CardsModel
import com.example.creditcardexpenses.domain.model.TransactionsModel
import kotlinx.coroutines.flow.Flow

interface TransactionsRepository {

    fun findAllTransactionsByCardId(cardId:Int) :Flow<List<TransactionsModel>>

    suspend fun findTransactionById(id:Int) : TransactionsModel

    suspend fun createTransaction(transactionEntity: TransactionEntity)

    suspend fun updateTransaction(id:Int, storename: String, trxcurrency :String, trxamount : Double)

    suspend fun deleteTransactionByCardId(cardId:Int)

    suspend fun deleteTransactionById(id:Int)

}