package com.strixapps.finalmvvm.di

import com.strixapps.data.di.InjectionQualifiers
import com.strixapps.domain.finalmvvm.usecase.DeletePokemonUseCase
import com.strixapps.domain.finalmvvm.usecase.GetSavedPokemonsUseCase
import com.strixapps.domain.finalmvvm.usecase.SavePokemonsUseCase
import com.strixapps.domain.finalmvvm.usecase.UpdatePokemonsUseCase
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val usecaseModule = module {

    single { GetSavedPokemonsUseCase(get(qualifier = qualifier(InjectionQualifiers.DB))) }

    single {
        UpdatePokemonsUseCase(
            remoteRepository = get(qualifier = qualifier(InjectionQualifiers.REMOTE)),
            dbRepository = get()
        )
    }

    single { DeletePokemonUseCase(get()) }

    single { SavePokemonsUseCase(get()) }
}