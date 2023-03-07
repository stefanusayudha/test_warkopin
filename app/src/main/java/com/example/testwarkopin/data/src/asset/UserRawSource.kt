package com.example.testwarkopin.data.src.asset

import com.example.testwarkopin.data.raw.UserRaw

interface UserRawSource {
    suspend fun getUserList() : List<UserRaw>
}