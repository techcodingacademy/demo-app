package com.data.remote

import com.data.model.UserDTO
import com.domain.User

fun UserDTO.toDomain(): User {
    return User(
        id = id,
        firstName = firstName,
        lastName = lastName,
        maidenName = maidenName,
        age = age,
        gender = gender,
        email = email,
        phone = phone,
        username = username,
        password = password,
        birthDate = birthDate,
        image = image
    )
}