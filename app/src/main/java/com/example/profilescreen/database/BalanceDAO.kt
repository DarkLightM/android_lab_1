package com.example.profilescreen.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.profilescreen.domain.models.Balance

@Dao
interface BalanceDAO {
    @Query("SELECT * FROM balance")
    fun getAll(): List<Balance>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addBalance(balance: Balance)
}