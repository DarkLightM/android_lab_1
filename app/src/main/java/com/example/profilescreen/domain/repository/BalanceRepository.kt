package com.example.profilescreen.domain.repository

import com.example.profilescreen.database.BalanceDAO
import com.example.profilescreen.domain.api.ApiProvider
import com.example.profilescreen.domain.models.Balance

class BalanceRepository(private val apiProvider: ApiProvider, private val balanceDAO: BalanceDAO) :
    IBalanceRepository {
    override suspend fun getBalance(): Balance = apiProvider.getApi().getBalance()[0]
    override suspend fun getBalanceDb(): List<Balance> = balanceDAO.getAll()
    override suspend fun addBalance(balance: Balance) = balanceDAO.addBalance(balance)

}