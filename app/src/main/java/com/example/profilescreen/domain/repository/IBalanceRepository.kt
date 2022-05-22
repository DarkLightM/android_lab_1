package com.example.profilescreen.domain.repository

import com.example.profilescreen.domain.models.Balance

interface IBalanceRepository {
    suspend fun getBalance(): Balance
    suspend fun getBalanceDb(): List<Balance>
    suspend fun addBalance(balance: Balance)
}