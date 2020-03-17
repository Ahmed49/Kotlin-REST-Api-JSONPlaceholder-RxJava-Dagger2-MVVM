package com.foxhole.kotlinrestapijsonplaceholder.di

import androidx.lifecycle.ViewModelProvider
import com.foxhole.kotlinrestapijsonplaceholder.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory
}