package com.example.creditcardexpenses.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class cardEntity(
   @PrimaryKey(autoGenerate = true) var id : Int = 0,
   @ColumnInfo(name = "brand") var brand : String = "",
   @ColumnInfo(name = "alias") var alias : String = "",
   @ColumnInfo(name = "validthru") var validThru : Int = 0,
   @ColumnInfo(name = "fourdigits") var fourDigits : Int = 0,
)
