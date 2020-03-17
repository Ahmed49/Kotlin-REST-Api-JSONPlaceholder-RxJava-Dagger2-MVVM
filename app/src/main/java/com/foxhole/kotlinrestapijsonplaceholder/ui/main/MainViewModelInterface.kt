package com.foxhole.kotlinrestapijsonplaceholder.ui.main

import androidx.lifecycle.LiveData
import com.foxhole.kotlinrestapijsonplaceholder.model.User

interface MainViewModelInterface {
    fun getUserList() : LiveData<Resource<List<User>>>
    fun loadUserList()
}