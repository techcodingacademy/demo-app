package com.presentation.screen.detail

import com.data.model.UserDTO
import com.domain.User

sealed class DetailUiState {
    object Loading: DetailUiState()
    data class Success(val user: User): DetailUiState()
    data class Error(val message: String): DetailUiState()
}