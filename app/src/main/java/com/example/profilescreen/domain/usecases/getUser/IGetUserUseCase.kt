package com.example.profilescreen.domain.usecases.getUser

import com.example.profilescreen.domain.models.User

interface IGetUserUseCase {
    suspend fun getUser(): User
}