package com.foxhole.kotlinrestapijsonplaceholder.ui.main

import com.foxhole.kotlinrestapijsonplaceholder.di.main.MainApi
import com.foxhole.kotlinrestapijsonplaceholder.model.User
import io.reactivex.Flowable
import io.reactivex.Observable

class MainRepository (private val mainApi: MainApi) : MainRepoInterface{

    override fun getAllUser(): Flowable<List<User>> {
        return mainApi.getAllUsers()
    }

}