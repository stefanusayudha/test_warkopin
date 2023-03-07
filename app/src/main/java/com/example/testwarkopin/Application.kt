package com.example.testwarkopin

import android.app.Application
import com.example.testwarkopin.data.dataModule
import com.example.testwarkopin.ui.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.core.logger.Level

class App : Application() {

    private val koinModules =
        listOf(
            uiModule,
            dataModule
        )

    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger(Level.DEBUG)
            androidContext(this@App)
            modules(koinModules)
        }
    }

    override fun onTerminate() {
        stopKoin()
        super.onTerminate()
    }
}