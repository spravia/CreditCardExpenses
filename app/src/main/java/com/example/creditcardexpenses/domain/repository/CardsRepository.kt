package com.example.creditcardexpenses.domain.repository

import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import com.example.creditcardexpenses.domain.model.CardsModel
import kotlinx.coroutines.flow.Flow

interface CardsRepository {
    fun findAll() :Flow<List<CardsModel>>

    suspend fun findCardById(id:Int) : CardsModel

    suspend fun create(cardEntity: cardEntity)

    suspend fun update(id:Int, brand:String, alias : String, validThru : Int, fourDigits :Int)

    suspend fun delete(id:Int)

}