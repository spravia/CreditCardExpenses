package com.example.creditcardexpenses.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import com.example.creditcardexpenses.data.dataSource.local.dao.CardsDAO
import com.example.creditcardexpenses.data.dataSource.local.dao.TransactionDAO
import com.example.creditcardexpenses.data.dataSource.local.entity.TransactionEntity


@Database(
    entities = [cardEntity::class,
                TransactionEntity::class],
    version = 1,
    exportSchema =false
)

abstract class CardsDB : RoomDatabase()
{
   abstract fun cardsDAO() : CardsDAO

   abstract fun transactionDAO() : TransactionDAO

}