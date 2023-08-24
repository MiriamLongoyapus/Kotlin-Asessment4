package com.example.assesment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assesment.R
import com.example.assesment.viewmodel.UsersViewModel

class MainActivity : AppCompatActivity() {
    val usersViewModel:UsersViewModel by viewModels()
    lateinit var binding: MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.btnF.setOnClickListener {
            val intent = Intent(this,UsersActivity::class.java)
            startActivity(intent)
        }
    }
}