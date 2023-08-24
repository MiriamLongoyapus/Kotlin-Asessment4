package com.example.assesment.models

data class UsersResponse(
    var users:List<Users>,
    var total:Int,
    var skip:Int,
    var limit:Int
)
