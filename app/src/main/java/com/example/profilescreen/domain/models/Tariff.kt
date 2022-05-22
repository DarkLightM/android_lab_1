package com.example.profilescreen.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tariff")
data class Tariff(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    val name: String,

    @ColumnInfo(name = "description")
    @SerializedName("desc")
    val description: String,

    @ColumnInfo(name = "cost")
    @SerializedName("cost")
    val amount: Double
)
