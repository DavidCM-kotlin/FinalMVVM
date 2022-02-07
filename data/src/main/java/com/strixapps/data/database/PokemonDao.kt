package com.strixapps.data.database

import androidx.room.*

@Dao
interface PokemonDao {

    @Query("SELECT * FROM ${PokemonModelDB.TABLENAME}")
    fun getPokemons() : List<PokemonModelDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePokemons(vararg pokemonModel:PokemonModelDB)

    @Query("DELETE FROM ${PokemonModelDB.TABLENAME}")
    suspend fun deleteAllPokemons()

    @Delete
    suspend fun deleteOnePokemon(pokemon: PokemonModelDB)
}