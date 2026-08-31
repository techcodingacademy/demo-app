package com.presentation.screen.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.data.remote.toDomain
import com.domain.usecase.GetUserByIdUseCase
import com.presentation.navigation.route.AppNavRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val userId: Int = savedStateHandle.toRoute<AppNavRoute.DetailRoute>().userId
    init {
        getUserById()
    }
    fun getUserById(){
        viewModelScope.launch {
            _uiState.value = DetailUiState.Loading
            try {
              val user = getUserByIdUseCase.invoke(userId)
              _uiState.value = DetailUiState.Success(user)
            }catch (e: Exception){
                DetailUiState.Error(e.message?:"Something went wrong")
            }

        }
    }
}