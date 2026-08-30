package com.presentation.screen.Home

import com.domain.User
import java.util.Collections.emptyList

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data class Success(
        val users: List<User> = emptyList()
    ) : HomeUiState()
    data class Error(val message: String): HomeUiState()
}