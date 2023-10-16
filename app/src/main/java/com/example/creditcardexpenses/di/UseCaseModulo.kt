package com.example.creditcardexpenses.di

import com.example.creditcardexpenses.domain.repository.CardsRepository
import com.example.creditcardexpenses.domain.useCase.CardsUseCases
import com.example.creditcardexpenses.domain.useCase.CreateCardUseCase
import com.example.creditcardexpenses.domain.useCase.DeleteCardUseCase
import com.example.creditcardexpenses.domain.useCase.GetCardByIdUseCase
import com.example.creditcardexpenses.domain.useCase.GetCardsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModulo {

    @Provides
    fun provideCardsUseCase(repository: CardsRepository) =
           CardsUseCases(getCardsUseCase = GetCardsUseCase(repository),
                         createCardUseCase = CreateCardUseCase(repository),
                         getCardById = GetCardByIdUseCase(repository),
                         deleteCard = DeleteCardUseCase(repository)
               )
}