package com.example.creditcardexpenses.data.dataSource.local

import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import kotlinx.coroutines.flow.Flow

interface CardsLocalDataSource {

        fun getCards() : Flow<List<cardEntity>>

        suspend fun create(cardEntity: cardEntity)

        suspend fun update(id:Int, brand:String, alias : String, validThru : Int, fourDigits :Int)

        suspend fun delete(id:Int)

}