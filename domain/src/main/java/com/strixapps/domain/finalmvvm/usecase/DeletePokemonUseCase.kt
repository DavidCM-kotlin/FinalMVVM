package com.strixapps.domain.finalmvvm.usecase

import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.domain.finalmvvm.repository.EditPokemonRepository

class DeletePokemonUseCase (private val pokemonRepository: EditPokemonRepository) : UseCase<PokemonModel,Unit>() {

    override suspend fun executeUseCase(input: PokemonModel) {
        pokemonRepository.deletePokemon(input)
    }
}


