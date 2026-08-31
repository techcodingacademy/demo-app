package com.data.remote

import androidx.compose.ui.util.fastMapNotNull
import com.domain.Repository
import com.domain.User
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val userApImp: UserApImp
) : Repository {
    override suspend fun getUsers(): List<User> {
        // when getUsers is called retrofit is trigger GET https://dummyjson.com/users fired
        // return UsersReposeDTO save in response.Response {UsersReposeDTO} has users as parameter
        // val users: List<UserDTO>, which is list of UserDTO iterate over each and convert to user
        val response = userApImp.getUsers()
      return  response.users.fastMapNotNull { userDTO -> userDTO.toDomain() }
    }

    override suspend fun getUserById(userId: Int): User {
        return userApImp.getUserById(userId).toDomain()
    }
}