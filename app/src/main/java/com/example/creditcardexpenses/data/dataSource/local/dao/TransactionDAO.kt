package com.example.creditcardexpenses.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.creditcardexpenses.data.dataSource.local.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface TransactionDAO {

    @Query("Select * from transactions Where cardId=:cardId")
    fun getTransactionsByCardId(cardId:Int) : Flow<List<TransactionEntity>>

    @Query("Select * from transactions Where id=:id")
    suspend fun getTransactionsById(id:Int) : TransactionEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transactionEntity: TransactionEntity)

    @Query("UPDATE transactions SET storename=:storename,  trxcurrency=:trxcurrency, trxamount=:trxamount Where id=:id")
    suspend fun updateTransaction(id:Int, storename: String, trxcurrency :String, trxamount : Double)

    @Query("DELETE FROM transactions WHERE id=:id")
    suspend fun deleteTransactionById(id: Int)

    @Query("Delete From transactions Where cardId=:cardId")
    suspend fun deleteTransactionByCardId(cardId:Int)
}