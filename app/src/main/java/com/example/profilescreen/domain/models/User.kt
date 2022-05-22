package com.example.profilescreen.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "first_name")
    @SerializedName("firstName")
    val firstName: String,

    @ColumnInfo(name = "last_name")
    @SerializedName("lastName")
    val lastName: String,

    @ColumnInfo(name = "address")
    @SerializedName("address")
    val address: String
)
