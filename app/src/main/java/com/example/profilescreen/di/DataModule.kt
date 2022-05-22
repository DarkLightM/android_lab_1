package com.example.profilescreen.di

import com.example.profilescreen.database.BalanceDAO
import com.example.profilescreen.database.TariffDAO
import com.example.profilescreen.database.UserDAO
import com.example.profilescreen.domain.api.ApiProvider
import com.example.profilescreen.domain.repository.*
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideUserRepo(apiProvider: ApiProvider, userDAO: UserDAO): IUserRepository =
        UserRepository(apiProvider, userDAO)

    @Provides
    fun provideBalanceRepo(apiProvider: ApiProvider, balanceDAO: BalanceDAO): IBalanceRepository =
        BalanceRepository(apiProvider, balanceDAO)

    @Provides
    fun provideTariffRepo(apiProvider: ApiProvider, tariffDAO: TariffDAO): ITariffRepository =
        TariffRepository(apiProvider, tariffDAO)

}