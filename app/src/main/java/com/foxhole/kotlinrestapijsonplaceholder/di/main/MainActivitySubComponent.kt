package com.foxhole.kotlinrestapijsonplaceholder.di.main

import com.foxhole.kotlinrestapijsonplaceholder.di.ViewModelFactoryModule
import com.foxhole.kotlinrestapijsonplaceholder.ui.main.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [
    MainModule::class,
    ViewModelFactoryModule::class,
    MainViewModelModule::class
])
interface  MainActivitySubComponent{
    fun inject(mainActivity: MainActivity)
}