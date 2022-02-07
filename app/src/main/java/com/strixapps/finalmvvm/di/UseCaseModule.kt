package com.strixapps.finalmvvm.di

import com.strixapps.data.di.InjectionQualifiers
import com.strixapps.domain.finalmvvm.usecase.DeletePokemonUseCase
import com.strixapps.domain.finalmvvm.usecase.GetSavedTransactionsUseCase
import com.strixapps.domain.finalmvvm.usecase.SaveTransactionsUseCase
import com.strixapps.domain.finalmvvm.usecase.UpdatePokemonsUseCase
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val usecaseModule = module {

    single { GetSavedTransactionsUseCase(get(qualifier = qualifier(InjectionQualifiers.DB))) }

    single {
        UpdatePokemonsUseCase(
            remoteRepository = get(qualifier = qualifier(InjectionQualifiers.REMOTE)),
            dbRepository = get()
        )
    }

    single { DeletePokemonUseCase(get()) }

    single { SaveTransactionsUseCase(get()) }
}