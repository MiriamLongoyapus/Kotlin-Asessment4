package com.example.assesment.api

import com.example.assesment.models.Users
import com.example.assesment.models.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {
    @GET("/users")
    suspend fun getUsers(): Response<UsersResponse>

    @GET("/users/{id}")
    suspend fun getUserById(@Path("id") userId: Int): Response<Users>
}

