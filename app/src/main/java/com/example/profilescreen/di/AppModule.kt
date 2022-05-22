package com.example.profilescreen.di

import android.app.Application
import com.example.profilescreen.domain.repository.IBalanceRepository
import com.example.profilescreen.domain.repository.ITariffRepository
import com.example.profilescreen.domain.repository.IUserRepository
import com.example.profilescreen.domain.usecases.getBalance.GetBalanceUseCase
import com.example.profilescreen.domain.usecases.getBalance.IGetBalanceUseCase
import com.example.profilescreen.domain.usecases.getTariffList.GetTariffListUseCase
import com.example.profilescreen.domain.usecases.getTariffList.IGetTariffListUseCase
import com.example.profilescreen.domain.usecases.getUser.GetUserUseCase
import com.example.profilescreen.domain.usecases.getUser.IGetUserUseCase
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideViewModel(): MainViewModel =
        MainViewModel()

    @Provides
    fun provideUserInfoUseCase(repo: IUserRepository): IGetUserUseCase =
        GetUserUseCase(repo)

    @Provides
    fun provideBalanceUseCase(repo: IBalanceRepository): IGetBalanceUseCase =
        GetBalanceUseCase(repo)

    @Provides
    fun provideTariffUseCase(repo: ITariffRepository): IGetTariffListUseCase =
        GetTariffListUseCase(repo)
}