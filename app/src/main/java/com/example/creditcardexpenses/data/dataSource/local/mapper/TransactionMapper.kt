package com.example.creditcardexpenses.data.dataSource.local.mapper

import com.example.creditcardexpenses.data.dataSource.local.entity.TransactionEntity
import com.example.creditcardexpenses.domain.model.TransactionsModel

fun TransactionEntity.toTransactionModel() : TransactionsModel
{
    return TransactionsModel(
        id = id,
        storename = storename,
        trxdate = trxdate.toInt(),
        trxamount = trxamount,
        trxcurrency = trxcurrency,
        cardId = cardId
    )
}

fun TransactionsModel.toTransactionEntity() : TransactionEntity
{
    return TransactionEntity(
        id = id,
        storename = storename,
        trxdate = trxdate.toString(),
        trxamount = trxamount,
        trxcurrency = trxcurrency,
        cardId = cardId
    )
}