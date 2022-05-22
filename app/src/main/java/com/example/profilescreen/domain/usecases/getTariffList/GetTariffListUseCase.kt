package com.example.profilescreen.domain.usecases.getTariffList

import com.example.profilescreen.domain.models.Tariff
import com.example.profilescreen.domain.repository.ITariffRepository

class GetTariffListUseCase (private val iTariffRepository: ITariffRepository): IGetTariffListUseCase {
    override suspend fun getTariff(): List<Tariff> = iTariffRepository.getTariffs()
}