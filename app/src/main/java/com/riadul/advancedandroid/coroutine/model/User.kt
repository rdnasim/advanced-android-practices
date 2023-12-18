package com.riadul.advancedandroid.coroutine.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val address: String,
    val phone: String,
    val website: String,
    val company: String,
    val username: String,
    val password: String,
    val confirmPassword: String,
    val token: String,
    val tokenType: String,
    val refreshToken: String
)
