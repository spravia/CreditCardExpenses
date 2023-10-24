package com.example.creditcardexpenses.di

import android.app.Application
import androidx.room.Room
import com.example.creditcardexpenses.data.dataSource.local.CardsLocalDataSource
import com.example.creditcardexpenses.data.dataSource.local.CardsLocalDataSourceImpl
import com.example.creditcardexpenses.data.dataSource.local.dao.CardsDAO
import com.example.creditcardexpenses.data.dataSource.local.db.CardsDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseRoomModule {

    @Provides
    @Singleton
    fun provideDataBase(app:Application) : CardsDB =

        Room.databaseBuilder(app, CardsDB::class.java, name = "cardsdb")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideCardsDao(db : CardsDB) : CardsDAO = db.cardsDAO()

    @Provides
    @Singleton
    fun provideCardsLocalDataSource(cardsDAO: CardsDAO) : CardsLocalDataSource = CardsLocalDataSourceImpl(cardsDAO)


}