package com.example.profilescreen.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "balance")
data class Balance(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("accNum")
    val id: Int,

    @ColumnInfo(name = "balance")
    @SerializedName("balance")
    val amount: Double,

    @ColumnInfo(name = "next_pay")
    @SerializedName("nextPay")
    val toPay: Double
)
