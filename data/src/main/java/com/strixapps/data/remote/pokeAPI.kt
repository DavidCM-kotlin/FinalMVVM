package com.strixapps.data.remote

import com.strixapps.domain.finalmvvm.model.PokemonModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface pokeAPI {

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: String): Response<List<PokemonModel>>

    @GET("pokemon")
    suspend fun getPokemonList(): Response <PokemonListRemote>
//    fun getPokemonList() : Flow<List<PokemonListRemote>>

}



