package com.example.profilescreen

import android.app.Application
import com.example.profilescreen.di.*
import dagger.internal.InstanceFactory.create

class App: Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().
        roomModule(RoomModule(this)).
        appModule(AppModule()).
        dataModule(DataModule()).
        domainModule(DomainModule()).build()
    }
}