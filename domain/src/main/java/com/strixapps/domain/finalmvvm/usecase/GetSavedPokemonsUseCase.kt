package com.strixapps.domain.finalmvvm.usecase


import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.domain.finalmvvm.repository.GetPokemonRepository

class GetSavedPokemonsUseCase(
    private val pokemonRepository: GetPokemonRepository
): UseCase<Unit, List<PokemonModel>>() {

    override suspend fun executeUseCase(input: Unit):List<PokemonModel> {
        return pokemonRepository.getPokemons().getOrDefault(emptyList())
    }
}
