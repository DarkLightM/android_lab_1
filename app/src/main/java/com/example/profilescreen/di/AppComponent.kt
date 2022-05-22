package com.example.profilescreen.di

import com.example.profilescreen.ui.main.MainFragment
import dagger.Component


@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        DomainModule::class,
        RoomModule::class,
    ]
)
interface AppComponent {
    fun inject(activity: MainFragment)

    fun inject(vm: MainViewModel)
}