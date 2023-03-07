package com.example.testwarkopin.data

import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.example.testwarkopin.data.src.AgentDataSource
import com.example.testwarkopin.data.src.UserDataSource
import com.example.testwarkopin.data.src.asset.UserAssetSource
import com.example.testwarkopin.data.src.asset.UserRawSource
import com.example.testwarkopin.data.src.rapid.AgentWebSource
import com.example.testwarkopin.domain.AgentRepository
import com.example.testwarkopin.domain.UserRepository
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single {
        ChuckerCollector(
            context = androidContext(),
            // Toggles visibility of the notification
            showNotification = true,
            // Allows to customize the retention period of collected data
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )
    }

    single {
        ChuckerInterceptor.Builder(context = androidApplication())
            // The previously created Collector
            .collector(get())
            // The max body content length in bytes, after this responses will be truncated.
            .maxContentLength(250_000L)
            // List of headers to replace with ** in the Chucker UI
            // .redactHeaders("Auth-Token", "Bearer")
            // Read the whole response body even when the client does not consume the response completely.
            // This is useful in case of parsing errors or when the response body
            // is closed before being read like in Retrofit with Void and Unit types.
            .alwaysReadResponseBody(true)
            // Use decoder when processing request and response bodies. When multiple decoders are installed they
            // are applied in an order they were added.
            // .addBodyDecoder(decoder)
            // Controls Android shortcut creation. Available in SNAPSHOTS versions only at the moment
            // .createShortcut(true)
            .build()
    }

    factory<UserRawSource> {
        UserAssetSource(androidContext())
    }

    factory<UserRepository> {
        UserDataSource(get())
    }

    single {
        OkHttpClient
            .Builder()
            .addInterceptor { chain ->

                // i don't think i need to intercept something
                val request = chain.request().newBuilder()
                    .addHeader("X-RapidAPI-Key", "78c20fec20mshcdb36b249d09c86p1d0f09jsn8ad3185c64a5")
                    .addHeader("X-RapidAPI-Hos", "realtor.p.rapidapi.com")
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(get<ChuckerInterceptor>())
            .build()
    }

    single<AgentWebSource>{
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://realtor.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AgentWebSource::class.java)
    }

    single<AgentRepository> {
        AgentDataSource(get())
    }
}