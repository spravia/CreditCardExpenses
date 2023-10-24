package com.example.creditcardexpenses.data.repository

import com.example.creditcardexpenses.data.dataSource.local.TransactionsLocalDataSource
import com.example.creditcardexpenses.data.dataSource.local.entity.TransactionEntity
import com.example.creditcardexpenses.data.dataSource.local.mapper.toTransactionModel
import com.example.creditcardexpenses.domain.model.TransactionsModel
import com.example.creditcardexpenses.domain.repository.TransactionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TransactionsRpositoryImpl(private val transactionsLocalDataSource: TransactionsLocalDataSource) : TransactionsRepository
{
    override fun findAllTransactionsByCardId(cardId: Int): Flow<List<TransactionsModel>> =
        flow{

        transactionsLocalDataSource.getTransactionsByCardId(cardId=cardId).collect()
        {
                it.run {

                    val data = it.map { transactionEntity -> transactionEntity.toTransactionModel() }
                    data.sortedByDescending { it.trxdate }
                    emit(data)
                }
        }
    }.flowOn(Dispatchers.IO)


    override suspend fun findTransactionById(id: Int): TransactionsModel
    {
        return transactionsLocalDataSource.getTransactionById(id).toTransactionModel()
    }

    override suspend fun createTransaction(transactionEntity: TransactionEntity)
    {
        try {
            transactionsLocalDataSource.createTransaction(transactionEntity)
        }catch ( _ : Exception){

        }
    }

    override suspend fun updateTransaction(
        id: Int,
        storename: String,
        trxcurrency: String,
        trxamount: Double
    ) {
        try {
           transactionsLocalDataSource.updateTransaction(id = id, storename=storename, trxcurrency=trxcurrency, trxamount=trxamount)
        }catch (_:Exception){

        }
    }

    override suspend fun deleteTransactionByCardId(cardId: Int)
    {
        try {
            transactionsLocalDataSource.deleteTransactionByCardId(cardId = cardId)
        }catch (_ : Exception){

        }
    }

    override suspend fun deleteTransactionById(id: Int)
    {
        try {
            transactionsLocalDataSource.deleteTransactionById(id = id)
        }catch ( _ : Exception){

        }
    }
}