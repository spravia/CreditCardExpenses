package com.example.creditcardexpenses.data.dataSource.local

import com.example.creditcardexpenses.data.dataSource.local.entity.TransactionEntity
import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import kotlinx.coroutines.flow.Flow

interface TransactionsLocalDataSource {

        fun getTransactionsByCardId(cardId:Int) : Flow<List<TransactionEntity>>

        suspend fun getTransactionById(id: Int) : TransactionEntity

        suspend fun createTransaction(transactionEntity: TransactionEntity)

        suspend fun updateTransaction(id:Int, storename: String, trxcurrency :String, trxamount : Double)

        suspend fun deleteTransactionByCardId(cardId:Int)

        suspend fun deleteTransactionById(id:Int)
}