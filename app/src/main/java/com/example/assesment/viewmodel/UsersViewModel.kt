package com.example.assesment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assesment.models.Users
import com.example.assesment.repository.UsersRepository

class UsersViewModel: ViewModel(){
    val usersRepo= UsersRepository()
    var usersLiveData= MutableLiveData<List<Users>>()
    var errorLiveData= MutableLiveData<String>()

    fun fetchUsers(){
        viewModelScope.launch {
            val response =usersRepo.getUsers()
            if(response.isSuccessful){
                usersLiveData.postValue(response.body()?.users)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}