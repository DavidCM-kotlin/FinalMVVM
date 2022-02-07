package com.strixapps.domain.finalmvvm.repository

import com.strixapps.domain.finalmvvm.model.PokemonModel

interface GetPokemonRepository {
    suspend fun getPokemons():Result<List<PokemonModel>>
}