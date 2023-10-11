package com.example.creditcardexpenses.data.dataSource.local

import com.example.creditcardexpenses.data.dataSource.local.dao.CardsDAO
import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import kotlinx.coroutines.flow.Flow

         //TODO esta es la implementacion del DAO con acceso a las acciones sobre la BD Room

class CardsLocalDataSourceImpl(private val cardsDAO: CardsDAO) : CardsLocalDataSource
{
    override fun getCards(): Flow<List<cardEntity>> = cardsDAO.getCards()

    override suspend fun create(cardEntity: cardEntity) = cardsDAO.insert(cardEntity = cardEntity)

    override suspend fun update(id: Int, brand: String, alias: String, validThru: Int, fourDigits: Int) =
                cardsDAO.update(id = id, brand = brand, alias = alias, validThru = validThru, fourDigits= fourDigits)

    override suspend fun delete(id: Int) = cardsDAO.delete(id = id)

}