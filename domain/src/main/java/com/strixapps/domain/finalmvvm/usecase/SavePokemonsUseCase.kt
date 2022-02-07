package com.strixapps.domain.finalmvvm.usecase

import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.domain.finalmvvm.repository.EditPokemonRepository

class SavePokemonsUseCase(
    private val pokemonRepository: EditPokemonRepository
):UseCase<List<PokemonModel>, Unit>() {

    override suspend fun executeUseCase (input:List<PokemonModel>){
        pokemonRepository.savePokemons(*input.toTypedArray())
    }
}