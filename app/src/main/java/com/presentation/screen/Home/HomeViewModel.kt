package com.presentation.screen.Home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    private val _users = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val users = _users.asStateFlow()
    init {
        getUsers()
    }
    fun getUsers() {
        viewModelScope.launch {
            try {
                _users.value = HomeUiState.Loading
                val users = getUsersUseCase.invoke()
                Log.d("HOME_VM", "users size = ${users.size}")
                _users.value = HomeUiState.Success(users)
            } catch (e: Exception) {
                _users.value = HomeUiState.Error(e.message ?: "Something went wrong")
            }
        }
    }
}