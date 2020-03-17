package com.foxhole.kotlinrestapijsonplaceholder.di

import com.foxhole.kotlinrestapijsonplaceholder.di.main.MainActivitySubComponent
import com.foxhole.kotlinrestapijsonplaceholder.di.modules.NetworkModule
import dagger.Component

@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun newMainActivitySubComponent() : MainActivitySubComponent
}