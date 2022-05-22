package com.example.profilescreen.database

import androidx.room.*
import com.example.profilescreen.domain.models.Tariff

@Dao
interface TariffDAO {
    @Query("SELECT * FROM tariff")
    fun getAll(): List<Tariff>

    @Delete
    fun deleteTariff(vararg tariff: Tariff)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTariff(vararg tariff: Tariff)
}