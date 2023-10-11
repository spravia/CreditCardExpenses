package com.example.creditcardexpenses.data.dataSource.local.mapper

import com.example.creditcardexpenses.data.dataSource.local.entity.cardEntity
import com.example.creditcardexpenses.domain.model.CardsModel

fun cardEntity.toCardsModel() : CardsModel
{
   return CardsModel(
       id = id,
       brand = brand,
       alias = alias,
       validThru = validThru,
       fourDigits = fourDigits
   )
}

fun CardsModel.toCardEntity() : cardEntity
{
    return cardEntity(
        id= id,
        brand = brand,
        alias = alias,
        validThru = validThru,
        fourDigits = fourDigits
    )
}