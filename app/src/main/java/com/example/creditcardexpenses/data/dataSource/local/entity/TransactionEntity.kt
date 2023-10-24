package com.example.creditcardexpenses.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionEntity(

   @PrimaryKey(autoGenerate = true)
   var id : Int = 0,

   @ColumnInfo(name = "storename")
   var storename : String = "",

   @ColumnInfo(name = "trxdate")
   var trxdate : String = "",

   @ColumnInfo(name = "trxcurrency")
   var trxcurrency : String = "",

   @ColumnInfo(name = "trxamount")
   var trxamount : Double  = 0.0,

   @ColumnInfo(name = "cardId")
   var cardId : Int
)
