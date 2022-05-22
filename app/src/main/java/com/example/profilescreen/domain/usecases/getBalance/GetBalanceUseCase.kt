package com.example.profilescreen.domain.usecases.getBalance

import com.example.profilescreen.domain.models.Balance
import com.example.profilescreen.domain.repository.IBalanceRepository

class GetBalanceUseCase (
    private val iBalanceRepository: IBalanceRepository
): IGetBalanceUseCase {
    override suspend fun getBalance(): Balance = iBalanceRepository.getBalance()
}