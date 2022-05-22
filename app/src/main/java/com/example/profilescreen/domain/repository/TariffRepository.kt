package com.example.profilescreen.domain.repository

import com.example.profilescreen.database.TariffDAO
import com.example.profilescreen.domain.api.ApiProvider
import com.example.profilescreen.domain.models.Tariff

class TariffRepository(private val apiProvider: ApiProvider, private val tariffDAO: TariffDAO) :ITariffRepository {
    override suspend fun getTariffs(): List<Tariff> = apiProvider.getApi().getTariffs()
    override suspend fun getTariffsDb(): List<Tariff> = tariffDAO.getAll()
    override suspend fun addTariff(tariff: Tariff) = tariffDAO.addTariff(tariff)
    override suspend fun deleteTariff(tariff: Tariff) = tariffDAO.deleteTariff(tariff)
}