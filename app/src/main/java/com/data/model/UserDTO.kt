package com.data.model

data class UserDTO(
    val id: Int,

    val firstName: String,

    val lastName: String,

    val maidenName: String,

    val age: Int,

    val gender: String,

    val email: String,

    val phone: String,

    val username: String,

    val password: String,

    val birthDate: String,

    val image: String,

    val bloodGroup: String,

    val height: Double,

    val weight: Double,

    val eyeColor: String,

    val hair: HairDTO,

    val ip: String,

    val address: AddressDTO,

    val macAddress: String,

    val university: String,

    val bank: BankDTO,

    val company: CompanyDTO,

    val ein: String,

    val ssn: String,

    val userAgent: String,

    val crypto: CryptoDTO,

    val role: String
)
