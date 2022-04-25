package com.example.profilescreen.ui.main

import com.google.gson.annotations.SerializedName

data class Balance(
    @SerializedName("accNum")
    val id: Int,
    @SerializedName("balance")
    val amount: Double,
    @SerializedName("nextPay")
    val toPay: Double
)
