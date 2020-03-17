package com.foxhole.kotlinrestapijsonplaceholder.ui.main

import com.foxhole.kotlinrestapijsonplaceholder.di.main.MainApi
import com.foxhole.kotlinrestapijsonplaceholder.model.User
import io.reactivex.Flowable
import io.reactivex.Observable

interface MainRepoInterface {
    fun getAllUser() : Flowable<List<User>>
}