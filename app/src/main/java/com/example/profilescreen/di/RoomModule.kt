package com.example.profilescreen.di

import android.app.Application
import android.content.Context
import com.example.profilescreen.database.AppDatabase
import com.example.profilescreen.database.BalanceDAO
import com.example.profilescreen.database.TariffDAO
import com.example.profilescreen.database.UserDAO
import dagger.Module
import dagger.Provides

@Module
class RoomModule(private val application: Application) {
    @Provides
    fun getBalanceDao(appDatabase: AppDatabase): BalanceDAO = appDatabase.balanceDao()

    @Provides
    fun getUserDao(appDatabase: AppDatabase): UserDAO = appDatabase.userDao()

    @Provides
    fun getTariffDao(appDatabase: AppDatabase): TariffDAO = appDatabase.tariffDao()

    @Provides
    fun provideRoomDb(): AppDatabase = AppDatabase.getDatabase(provideAppContext())

    @Provides
    fun provideAppContext(): Context = application.applicationContext

}