package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapp.Adapter.UsersAdapter
import com.example.kotlinapp.Model.User
import com.example.kotlinapp.Model.response
import com.example.kotlinapp.Network.APIs
import com.example.kotlinapp.Network.RetrofitClient
import com.example.kotlinapp.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
// var users:ArrayList<User> = TODO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


var mainViewModel  : MainViewModel= ViewModelProviders.of(this).get(MainViewModel::class.java);

        mainViewModel.fetchAllUsers().observe(this,  Observer<List<User>>() {
            recyclerView.adapter=UsersAdapter(it)
        })
}
}