package com.riadul.advancedandroid.coroutine.model

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User> {
        delay(8000)
        val users = listOf(
            User(
                id = 1,
                name = "John Doe",
                email = "john.doe@example.com",
                address = "123 Main St, Cityville",
                phone = "555-1234",
                website = "www.johndoe.com",
                company = "ABC Inc.",
                username = "johndoe123",
                password = "securepassword",
                confirmPassword = "securepassword",
                token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9",
                tokenType = "Bearer",
                refreshToken = "refreshToken123"
            ),
            User(
                id = 2,
                name = "Jane Smith",
                email = "jane.smith@example.com",
                address = "456 Oak St, Townsville",
                phone = "555-5678",
                website = "www.janesmith.com",
                company = "XYZ Corp",
                username = "janesmith456",
                password = "strongpassword",
                confirmPassword = "strongpassword",
                token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9",
                tokenType = "Bearer",
                refreshToken = "refreshToken456"
            ),
            User(
                id = 3,
                name = "Bob Johnson",
                email = "bob.johnson@example.com",
                address = "789 Pine St, Villagetown",
                phone = "555-8765",
                website = "www.bobjohnson.com",
                company = "123 Co.",
                username = "bob123",
                password = "mypassword",
                confirmPassword = "mypassword",
                token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9",
                tokenType = "Bearer",
                refreshToken = "refreshToken789"
            ),
        )
        return users
    }
}