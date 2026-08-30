package com.data.model

data class UsersReposeDTO(
    val users: List<UserDTO>,

    val total: Int,

    val skip: Int,

    val limit: Int
)
