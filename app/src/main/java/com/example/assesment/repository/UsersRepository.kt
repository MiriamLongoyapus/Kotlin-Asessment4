package com.example.assesment.repository

import com.example.assesment.api.ApiClient
import com.example.assesment.api.ApiInterface
import com.example.assesment.models.Users
import com.example.assesment.models.UsersResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class UsersRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getUsers(): Response<UsersResponse> {
        return withContext(Dispatchers.IO) {
            apiClient.getUsers()
        }
    }

    suspend fun getUserById(userId: Int): Response<Users> {
        return withContext(Dispatchers.IO) {
            apiClient.getUserById(userId)
        }
    }
}




