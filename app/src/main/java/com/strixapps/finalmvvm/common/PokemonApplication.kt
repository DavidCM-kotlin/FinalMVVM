package com.strixapps.finalmvvm.common

import android.app.Application
import com.strixapps.data.di.dataModule
import com.strixapps.finalmvvm.di.uiModule
import com.strixapps.finalmvvm.di.usecaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokemonApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@PokemonApplication)
            modules(uiModule, dataModule, usecaseModule)
        }
    }
}