package com.example.creditcardexpenses.data.repository

import android.util.Log
import com.example.creditcardexpenses.data.dataSource.local.CardsLocalDataSource
import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import com.example.creditcardexpenses.data.dataSource.local.mapper.toCardsModel
import com.example.creditcardexpenses.domain.model.CardsModel
import com.example.creditcardexpenses.domain.repository.CardsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CardsRpositoryImpl(private val cardDataSource : CardsLocalDataSource) : CardsRepository
{
    override fun findAll(): Flow<List<CardsModel>> = flow {

        try {
            cardDataSource.getCards().collect {

                it.run {
                    val data = it.map {  cardEntity ->  cardEntity.toCardsModel() }
                    emit(data)
                }
            }
        }catch (_:Exception){

        }
    }.flowOn(Dispatchers.IO)

    override suspend fun findCardById(id: Int): CardsModel
    {
       return cardDataSource.getCardById(id).toCardsModel()
    }

    override suspend fun create(cardEntity: cardEntity) {
        try {
            cardDataSource.create(cardEntity)
        }catch (_:Exception){

        }
    }

    override suspend fun update(id: Int, brand: String, alias: String, validThru: Int, fourDigits: Int)
    {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int) {

            try {
                cardDataSource.delete(id)
            }catch (_:Exception){

            }
    }
}