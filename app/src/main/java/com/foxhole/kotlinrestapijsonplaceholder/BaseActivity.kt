package com.foxhole.kotlinrestapijsonplaceholder

import android.app.Application
import android.util.Log
import com.foxhole.kotlinrestapijsonplaceholder.di.AppComponent
import com.foxhole.kotlinrestapijsonplaceholder.di.DaggerAppComponent
import com.foxhole.kotlinrestapijsonplaceholder.di.modules.NetworkModule

class BaseActivity  : Application() {

    lateinit var appComponent : AppComponent


    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.intDagger()
    }

    private fun intDagger() = DaggerAppComponent.builder()
        .networkModule(NetworkModule())
        .build()
}