package com.strixapps.data.di

import com.strixapps.data.database.PokeRepository
import com.strixapps.data.remote.PokemonRepository
import com.strixapps.domain.finalmvvm.repository.EditPokemonRepository
import com.strixapps.domain.finalmvvm.repository.GetPokemonRepository
import com.strixapps.domain.finalmvvm.usecase.DeletePokemonUseCase
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val dataModule = module {

    single { PokeRepository(get()) }

    single<GetPokemonRepository>(qualifier = qualifier(InjectionQualifiers.DB)) {
        get<PokeRepository>()
    }

    single<GetPokemonRepository>(qualifier = qualifier(InjectionQualifiers.REMOTE)) {
        PokemonRepository()
    }

    single<EditPokemonRepository> {
        get<PokeRepository>()
    }
}