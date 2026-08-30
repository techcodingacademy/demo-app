package com.data.remote

import androidx.compose.ui.util.fastMapNotNull
import com.data.model.UserDTO
import com.domain.Repository
import com.domain.User
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val userApImp: UserApImp
) : Repository {
    override suspend fun getUsers(): List<User> {
        val response = userApImp.getUsers()
      return  response.users.fastMapNotNull { userDTO -> userDTO.toDomain() }
    }

    override suspend fun getUserById(userId: Int): UserDTO {
        return userApImp.getUserById(userId)
    }
}