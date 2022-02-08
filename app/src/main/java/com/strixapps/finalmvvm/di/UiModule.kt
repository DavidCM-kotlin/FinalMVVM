package com.strixapps.finalmvvm.di

import com.strixapps.finalmvvm.ui.main.MainViewModel
import com.strixapps.finalmvvm.ui.main.home.HomeViewModel
import com.strixapps.finalmvvm.ui.main.userSettings.UserSettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val uiModule = module {

    viewModel {
        HomeViewModel(get(),get(),get())
    }

    viewModel {
        MainViewModel()
    }

//    viewModel {
//      DetailViewModel(get())
//    }

//    viewModel {
//        UserSettingsViewModel(get())
//    }
}