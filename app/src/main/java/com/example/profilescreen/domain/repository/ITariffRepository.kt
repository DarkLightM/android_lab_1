package com.example.profilescreen.domain.repository

import com.example.profilescreen.domain.models.Tariff

interface ITariffRepository {
    suspend fun getTariffs(): List<Tariff>
    suspend fun getTariffsDb(): List<Tariff>
    suspend fun addTariff(tariff: Tariff)
    suspend fun deleteTariff(tariff: Tariff)
}