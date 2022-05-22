package com.example.profilescreen.domain.api

import com.example.profilescreen.domain.models.Balance
import com.example.profilescreen.domain.models.Tariff
import com.example.profilescreen.domain.models.User
import retrofit2.http.GET

interface ApiService {
    @GET("userInfo")
    suspend fun getUserInfo(): List<User>

    @GET ("tariffs")
    suspend fun getTariffs(): List<Tariff>

    @GET("balance")
    suspend fun getBalance(): List<Balance>
}