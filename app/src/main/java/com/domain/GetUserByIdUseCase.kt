package com.domain
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(userId: Int): User {
        return repository.getUserById(userId)
    }
}