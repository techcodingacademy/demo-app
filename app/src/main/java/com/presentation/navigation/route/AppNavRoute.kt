package com.presentation.navigation.route

import kotlinx.serialization.Serializable
@Serializable
sealed class AppNavRoute {
    @Serializable
    data object HomeRoute : AppNavRoute()
    @Serializable
    data class DetailRoute(val userId: Int) : AppNavRoute()
}