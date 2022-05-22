package com.example.profilescreen.domain.usecases.getUser

import com.example.profilescreen.domain.models.User
import com.example.profilescreen.domain.repository.IUserRepository

class GetUserUseCase (private val iUserRepository: IUserRepository): IGetUserUseCase {
    override suspend fun getUser(): User = iUserRepository.getUserInfo()
}