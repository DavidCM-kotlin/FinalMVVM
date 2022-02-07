package com.strixapps.domain.finalmvvm.repository

import com.strixapps.domain.finalmvvm.model.PokemonModel

interface EditPokemonRepository {
    suspend fun deletePokemon(pokemonModel: PokemonModel)

    suspend fun savePokemons(vararg pokemons:PokemonModel)
}