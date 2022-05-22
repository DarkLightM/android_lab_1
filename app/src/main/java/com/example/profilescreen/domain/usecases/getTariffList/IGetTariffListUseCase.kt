package com.example.profilescreen.domain.usecases.getTariffList

import com.example.profilescreen.domain.models.Tariff

interface IGetTariffListUseCase {
    suspend fun getTariff(): List<Tariff>
}