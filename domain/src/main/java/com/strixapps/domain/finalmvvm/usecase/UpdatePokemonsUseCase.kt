package com.strixapps.domain.finalmvvm.usecase

import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.domain.finalmvvm.repository.EditPokemonRepository
import com.strixapps.domain.finalmvvm.repository.GetPokemonRepository

class UpdatePokemonsUseCase(
    private val remoteRepository:GetPokemonRepository,
    private val dbRepository: EditPokemonRepository
):UseCase<Unit, Result<List<PokemonModel>>>() {

    override suspend fun executeUseCase(input: Unit): Result<List<PokemonModel>> {
        return remoteRepository.getPokemons().map { it ->
            val listFormatted = it.map { it.copy(id = it.id) }
            dbRepository.savePokemons(*listFormatted.toTypedArray())
            listFormatted
        }
    }
}

