package com.domain

import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<User> {
        return repository.getUsers()
    }
}