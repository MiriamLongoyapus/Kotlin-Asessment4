package com.example.assesment.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

class UsersActivity (): AppCompatActivity() {
    val usersViewModel: UsersViewModel by viewModels()
    lateinit var binding: ActivityUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()


        usersViewModel.fetchUsers()
        usersViewModel.usersLiveData.observe(this, Observer { usersList ->
            Toast.makeText(
                baseContext,
                "fetched ${usersList?.size} users",
                Toast.LENGTH_LONG
            ).show()
            binding.rvUsers.layoutManager = LinearLayoutManager(this@UsersActivity)
            binding.rvUsers.adapter = UsersRvAdapter(usersList)
        })
        usersViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(
                baseContext, error,
                Toast.LENGTH_LONG
            ).show()
        })
    }}