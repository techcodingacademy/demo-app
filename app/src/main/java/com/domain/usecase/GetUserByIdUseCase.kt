package com.domain.usecase

import com.domain.Repository
import com.domain.User
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(userId: Int): User {
        return repository.getUserById(userId)
    }
}