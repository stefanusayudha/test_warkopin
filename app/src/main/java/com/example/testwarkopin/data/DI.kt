package com.example.testwarkopin.data

import com.example.testwarkopin.data.src.UserDataSource
import com.example.testwarkopin.data.src.UserRawSource
import com.example.testwarkopin.data.src.asset.UserAssetSource
import com.example.testwarkopin.domain.UserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    factory<UserRawSource> {
        UserAssetSource(androidContext())
    }

    factory<UserRepository> {
        UserDataSource(get())
    }
}