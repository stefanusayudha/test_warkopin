package com.example.testwarkopin.domain

import com.example.testwarkopin.domain.model.User

interface UserRepository {
    suspend fun getUserList(): List<User>
}