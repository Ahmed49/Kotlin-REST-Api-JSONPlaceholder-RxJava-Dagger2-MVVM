package com.foxhole.kotlinrestapijsonplaceholder.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.foxhole.kotlinrestapijsonplaceholder.BaseActivity
import com.foxhole.kotlinrestapijsonplaceholder.R
import com.foxhole.kotlinrestapijsonplaceholder.adapter.RecyclerViewAdapter
import com.foxhole.kotlinrestapijsonplaceholder.factory.ViewModelFactory
import com.foxhole.kotlinrestapijsonplaceholder.model.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val _tag : String = MainActivity::class.java.name
    private lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (this.applicationContext as BaseActivity).appComponent.newMainActivitySubComponent().inject(this)

        mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        observeUserList()
    }

    private fun observeUserList() {
        mainViewModel.getUserList().observe(this, Observer {
            when(it.status){
                Resource.Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                }
                Resource.Status.SUCCESS -> {
                    progressBar.visibility = View.INVISIBLE
                    intRecyclerView(it.data)
                }
                Resource.Status.ERROR -> {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun intRecyclerView(list: List<User>?) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        list?.let { recyclerViewAdapter.setUserList(it) }
        recyclerView.adapter = recyclerViewAdapter

    }

}
