package com.example.creditcardexpenses.data.dataSource.local

import com.example.creditcardexpenses.data.dataSource.local.dao.TransactionDAO
import com.example.creditcardexpenses.data.dataSource.local.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

//TODO esta es la implementacion del DAO con acceso a las acciones sobre la BD Room

class TransacionsLocalDataSourceImpl(private val transactionDAO: TransactionDAO) : TransactionsLocalDataSource
{
    override fun getTransactionsByCardId(cardId: Int): Flow<List<TransactionEntity>> = transactionDAO.getTransactionsByCardId(cardId=cardId)

    override suspend fun getTransactionById(id:Int): TransactionEntity = transactionDAO.getTransactionsById(id = id)

    override suspend fun createTransaction(transactionEntity: TransactionEntity) = transactionDAO.insertTransaction(transactionEntity)

    override suspend fun updateTransaction(
        id: Int,
        storename: String,
        trxcurrency: String,
        trxamount: Double
    ) = transactionDAO.updateTransaction(id =id, storename = storename, trxcurrency = trxcurrency, trxamount=trxamount)

    override suspend fun deleteTransactionByCardId(cardId: Int) = transactionDAO.deleteTransactionByCardId(cardId=cardId)

    override suspend fun deleteTransactionById(id: Int) = transactionDAO.deleteTransactionById(id = id)


}