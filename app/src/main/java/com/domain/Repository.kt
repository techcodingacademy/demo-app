package com.domain

import com.data.model.UserDTO

interface Repository {
    suspend fun getUsers(): List<User>
    suspend fun getUserById(userId: Int): UserDTO
}