package com.example.creditcardexpenses.di

import com.example.creditcardexpenses.data.dataSource.local.CardsLocalDataSource
import com.example.creditcardexpenses.data.dataSource.local.TransactionsLocalDataSource
import com.example.creditcardexpenses.data.repository.CardsRpositoryImpl
import com.example.creditcardexpenses.data.repository.TransactionsRpositoryImpl
import com.example.creditcardexpenses.domain.repository.CardsRepository
import com.example.creditcardexpenses.domain.repository.TransactionsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideCardsRepository(cardsLocalDataSource: CardsLocalDataSource)
          : CardsRepository = CardsRpositoryImpl(cardsLocalDataSource)


    @Provides
    fun provideTransactionRepository(transactionsLocalDataSource: TransactionsLocalDataSource)
        : TransactionsRepository = TransactionsRpositoryImpl(transactionsLocalDataSource)
}