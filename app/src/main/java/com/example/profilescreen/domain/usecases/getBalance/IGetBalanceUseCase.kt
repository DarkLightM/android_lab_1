package com.example.profilescreen.domain.usecases.getBalance

import com.example.profilescreen.domain.models.Balance

interface IGetBalanceUseCase {
    suspend fun getBalance(): Balance
}