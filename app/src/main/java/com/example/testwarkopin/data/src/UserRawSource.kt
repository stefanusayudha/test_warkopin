package com.example.testwarkopin.data.src

import com.example.testwarkopin.data.raw.UserRaw

interface UserRawSource {
    suspend fun getUserList() : List<UserRaw>
}