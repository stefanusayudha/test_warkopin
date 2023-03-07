package com.example.testwarkopin.ui

import com.example.testwarkopin.ui.screen.one.ScreenOneViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        ScreenOneViewModel(get())
    }
}