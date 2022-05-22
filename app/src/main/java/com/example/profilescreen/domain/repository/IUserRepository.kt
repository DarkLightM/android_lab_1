package com.example.profilescreen.domain.repository

import com.example.profilescreen.domain.models.User

interface IUserRepository {
    suspend fun getUserInfo(): User
    suspend fun getUserInfoDb(): List<User>
    suspend fun addUserInfo(user: User)
}