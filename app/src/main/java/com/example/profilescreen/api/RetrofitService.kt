package com.example.profilescreen.api

import com.example.profilescreen.ui.main.Balance
import com.example.profilescreen.ui.main.Tariff
import com.example.profilescreen.ui.main.User
import retrofit2.http.GET;

interface RetrofitServices {
    @GET("/balance")
    suspend fun getBalanceList(): List<Balance>

    @GET("/tariffs")
    suspend fun getTariffsList(): List<Tariff>

    @GET("/userInfo")
    suspend fun getUserList(): List<User>
}