package com.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.presentation.screen.Home.HomeViewModel
import com.presentation.navigation.route.AppNavRoute
import com.presentation.screen.detail.DetailViewModel
import com.presentation.screen.Home.HomeScreen
import com.presentation.screen.detail.DetailScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppNavRoute.HomeRoute
    ) {
        composable<AppNavRoute.HomeRoute> {
            val homeViewModel: HomeViewModel = hiltViewModel()
            val uiState by homeViewModel.users.collectAsStateWithLifecycle()
            HomeScreen(
                uiState = uiState,
                onUserClick = { user ->
                    navController.navigate(
                        AppNavRoute.DetailRoute(userId = user.id)
                    )
                }
            )
        }

        composable<AppNavRoute.DetailRoute> {
            val detailViewModel: DetailViewModel = hiltViewModel()
            val detailUiState by detailViewModel.uiState.collectAsStateWithLifecycle()
            DetailScreen(
                detailUiState = detailUiState,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

    }
}

