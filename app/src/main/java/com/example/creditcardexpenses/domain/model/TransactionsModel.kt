package com.example.creditcardexpenses.domain.model

data class TransactionsModel(
    var id : Int = 0,
    var storename : String = "",
    var trxdate : String =  "",
    var trxcurrency : String =  "",
    var trxamount : Double =  0.00,
    var cardId : Int
)
