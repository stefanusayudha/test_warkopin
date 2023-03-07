package com.example.testwarkopin.data.src

import com.example.testwarkopin.domain.UserRepository
import com.example.testwarkopin.domain.model.User

class UserDataSource(
    val src: UserRawSource
) : UserRepository {
    override suspend fun getUserList(): List<User> {
        return src.getUserList().map {
            User(
                id = it.id.toString(),
                name = it.name.toString(),
                email = it.email.toString()
            )
        }
    }
}