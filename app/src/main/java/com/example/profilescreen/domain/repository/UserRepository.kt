package com.example.profilescreen.domain.repository

import com.example.profilescreen.database.UserDAO
import com.example.profilescreen.domain.api.ApiProvider
import com.example.profilescreen.domain.models.User

class UserRepository(private val apiProvider: ApiProvider, private val userDAO: UserDAO):IUserRepository {
    override suspend fun getUserInfo(): User = apiProvider.getApi().getUserInfo()[0]
    override suspend fun getUserInfoDb(): List<User> = userDAO.getAll()
    override suspend fun addUserInfo(user: User) = userDAO.addUser(user)
}