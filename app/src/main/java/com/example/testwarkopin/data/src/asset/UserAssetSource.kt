package com.example.testwarkopin.data.src.asset

import android.content.Context
import android.util.Log
import com.example.testwarkopin.data.raw.UserRaw
import com.example.testwarkopin.data.src.UserRawSource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class UserAssetSource(
    private val context: Context
) : UserRawSource {
    override suspend fun getUserList(): List<UserRaw> {
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("dummy.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            Log.e("TAG", "getUserList: ${ioException.message}")
        }

        val listUser = object : TypeToken<List<UserRaw>>() {}.type
        return Gson().fromJson(jsonString, listUser)
    }
}