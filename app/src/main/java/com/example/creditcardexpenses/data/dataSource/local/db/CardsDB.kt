package com.example.creditcardexpenses.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import com.example.creditcardexpenses.data.dataSource.local.dao.CardsDAO


@Database(
    entities = [cardEntity::class],
    version = 1,
    exportSchema =false
)

abstract class CardsDB : RoomDatabase()
{
   abstract fun cardsDAO() : CardsDAO

}