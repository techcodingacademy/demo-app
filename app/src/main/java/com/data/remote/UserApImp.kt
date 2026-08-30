package com.data.remote

import com.data.model.UserDTO
import com.data.model.UsersReposeDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApImp {
    @GET("users")
    suspend fun getUsers(): UsersReposeDTO
    @GET("users/{id}")
    suspend fun getUserById(@Path("id") userId: Int): UserDTO
}
