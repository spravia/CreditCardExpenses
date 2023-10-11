package com.example.creditcardexpenses.di

import com.example.creditcardexpenses.data.dataSource.local.CardsLocalDataSource
import com.example.creditcardexpenses.data.repository.CardsRpositoryImpl
import com.example.creditcardexpenses.domain.repository.CardsRepository
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
}