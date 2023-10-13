package com.example.creditcardexpenses.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CardsDAO {


    @Query("Select * from cards")
    fun getCards() : Flow<List<cardEntity>>

    @Query("Select * from cards WHERE id = :id")
    suspend fun getCardById(id : Int) : cardEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cardEntity: cardEntity)

    @Query("UPDATE cards SET brand=:brand, alias=:alias , validthru=:validThru, fourdigits=:fourDigits WHERE id=:id")
    suspend fun update(id:Int, brand:String, alias : String, validThru : Int, fourDigits :Int)

    @Query("DELETE FROM cards WHERE id=:id")
    suspend fun delete(id: Int)
}