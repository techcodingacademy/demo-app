package com.data.model

data class AddressDTO(
    val address: String,

    val city: String,

    val state: String,

    val stateCode: String,

    val postalCode: String,

    val coordinates: CoordinatesDTO,

    val country: String
)
