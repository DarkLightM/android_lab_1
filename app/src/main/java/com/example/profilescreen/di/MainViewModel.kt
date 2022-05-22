package com.example.profilescreen.di

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profilescreen.App
import com.example.profilescreen.domain.models.Balance
import com.example.profilescreen.domain.models.Tariff
import com.example.profilescreen.domain.models.User
import com.example.profilescreen.domain.repository.*
import com.example.profilescreen.domain.usecases.getBalance.IGetBalanceUseCase
import com.example.profilescreen.domain.usecases.getTariffList.IGetTariffListUseCase
import com.example.profilescreen.domain.usecases.getUser.IGetUserUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel() : ViewModel() {
    @Inject
    lateinit var balanceUseCase: IGetBalanceUseCase
    @Inject
    lateinit var tariffsUseCase: IGetTariffListUseCase
    @Inject
    lateinit var userInfoUseCase: IGetUserUseCase
    @Inject
    lateinit var balanceRepository: IBalanceRepository
    @Inject
    lateinit var tariffRepository: ITariffRepository
    @Inject
    lateinit var userRepository: IUserRepository

    var balance = MutableLiveData<Balance>()
    val tariffs = MutableLiveData<List<Tariff>>()
    val user = MutableLiveData<User>()

    init {
        App.appComponent.inject(this)
    }

    fun getData() {
        viewModelScope.launch {
            balance.value = balanceUseCase.getBalance()
            tariffs.value = tariffsUseCase.getTariff()
            user.value = userInfoUseCase.getUser()
            Log.e("AAA", "getData done")
        }
    }

    fun fillDatabase(){
        viewModelScope.launch {
            balanceRepository.addBalance(balanceUseCase.getBalance())
            tariffsUseCase.getTariff().forEach(){
                tariffRepository.addTariff(it)
            }
            userRepository.addUserInfo(userInfoUseCase.getUser())
        }
    }

}