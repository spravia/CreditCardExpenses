package com.example.creditcardexpenses.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class CardsModel(
    var id : Int = 0,
    var brand : String = "",
    var alias : String =  "",
    var validThru : Int =  0,
    var fourDigits : Int =  0,
    )
