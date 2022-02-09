package com.strixapps.finalmvvm.ui.main.details

import androidx.lifecycle.MutableLiveData
import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.finalmvvm.common.BaseViewModel
import com.strixapps.finalmvvm.ui.main.MainViewModel

class DetailsViewModel : BaseViewModel() {

    private val liveTransaction = MutableLiveData<PokemonModel>()
    val obsPokemon = liveTransaction

    fun onAttachTransaction(pokemon: PokemonModel) {
        liveTransaction.value = pokemon
        mainViewModel.showFab(false)
    }

    override fun onInitialization() {
    }

    override fun onCleared() {
        mainViewModel.showFab(true)
        super.onCleared()
    }

}