package com.strixapps.data.database

import com.strixapps.data.BuildConfig.DB_NAME
import android.content.Context
import androidx.room.Room
import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.domain.finalmvvm.repository.EditPokemonRepository
import com.strixapps.domain.finalmvvm.repository.GetPokemonRepository

class PokeRepository(private val context: Context) :
    EditPokemonRepository, GetPokemonRepository {

    private val appDatabase = Room.databaseBuilder(
        context, PokemonDatabase::class.java, DB_NAME
    ).build()

    override suspend fun getPokemons(): Result<List<PokemonModel>> {
        val list = appDatabase.pokemonDao().getPokemons().map {
            it.toDomain()
        }
        return Result.success(list)
    }

    override suspend fun deletePokemon(pokemonModel: PokemonModel) {
        appDatabase.pokemonDao().deleteOnePokemon(pokemonModel.toDataDB())
    }

    override suspend fun savePokemons(vararg pokemons: PokemonModel) {
        appDatabase.pokemonDao().savePokemons(*pokemons.map { it.toDataDB() }.toTypedArray())
    }


}

