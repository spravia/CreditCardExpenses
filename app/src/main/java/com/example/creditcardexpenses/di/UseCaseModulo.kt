package com.example.creditcardexpenses.di

import com.example.creditcardexpenses.domain.repository.CardsRepository
import com.example.creditcardexpenses.domain.repository.TransactionsRepository
import com.example.creditcardexpenses.domain.useCase.CardsUseCases
import com.example.creditcardexpenses.domain.useCase.CardUseCases.CreateCardUseCase
import com.example.creditcardexpenses.domain.useCase.CardUseCases.DeleteCardUseCase
import com.example.creditcardexpenses.domain.useCase.CardUseCases.GetCardByIdUseCase
import com.example.creditcardexpenses.domain.useCase.CardUseCases.GetCardsUseCase
import com.example.creditcardexpenses.domain.useCase.TransactionUseCases.DeleteTransactionByIdUseCase
import com.example.creditcardexpenses.domain.useCase.TransactionUseCases.DeleteTransactionsByCardIdUseCase
import com.example.creditcardexpenses.domain.useCase.TransactionUseCases.GetTransactionByIdUseCase
import com.example.creditcardexpenses.domain.useCase.TransactionUseCases.GetTransactionsByCardIdUseCase
import com.example.creditcardexpenses.domain.useCase.TransactionUseCases.InsertTransactionUseCase
import com.example.creditcardexpenses.domain.useCase.TransactionUseCases.UpdateTransactionUseCase
import com.example.creditcardexpenses.domain.useCase.TransactionsUseCases
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

    @Provides
    fun provideTransactionUseCase(repository: TransactionsRepository) =
         TransactionsUseCases(
              getTransactionById = GetTransactionByIdUseCase(repository=repository),
              getTransactionsByCardId = GetTransactionsByCardIdUseCase(repository=repository),
              updateTransaction = UpdateTransactionUseCase(repository=repository),
              insertTransaction = InsertTransactionUseCase(repository=repository),
              deleteTransactionById = DeleteTransactionByIdUseCase(repository=repository),
              deleteTransactionsByCardId = DeleteTransactionsByCardIdUseCase(repository=repository)
         )
}