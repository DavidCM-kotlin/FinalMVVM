package com.strixapps.finalmvvm.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.strixapps.finalmvvm.common.BaseViewModel
import com.strixapps.finalmvvm.common.NavData
import com.strixapps.domain.finalmvvm.exception.TransactionExceptions
import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.domain.finalmvvm.usecase.GetSavedPokemonsUseCase
import com.strixapps.domain.finalmvvm.usecase.UpdatePokemonsUseCase
import com.strixapps.finalmvvm.ui.dialog.DialogData

class HomeViewModel(
    private val updatePokemonsUseCase: UpdatePokemonsUseCase,
    private val getSavedPokemonsUseCase: GetSavedPokemonsUseCase) : BaseViewModel() {

    companion object {
        const val NAV_DETAIL = 0
    }

    private val liveListPokemons: MutableLiveData<List<PokemonModel>> = MutableLiveData()
    val obsListPokemon: LiveData<List<PokemonModel>> = liveListPokemons

    override fun onInitialization() {
        executeUseCase {
            liveListPokemons.value = getSavedPokemonsUseCase.execute(Unit)
        }
    }

    fun onActionDownloadClicked() {
        showLoading()
        executeUseCase(
            finalAction = {hideLoading()
            }
        ) {
            val result = updatePokemonsUseCase.execute(Unit)
            result.onSuccess {
                liveListPokemons.value = it
                liveShowMessage.value = "Data go from remote successfully."
            }.onFailure {
                handleUpdateException(it)
            }
        }
    }

    private fun handleUpdateException(it: Throwable) {
        if (it is TransactionExceptions) {
            when (it) {
                is TransactionExceptions.GenericError -> {
                    liveShowDialog.value = DialogData(true, it.message)
                }
                is TransactionExceptions.HttpError -> {
                    liveShowDialog.value = DialogData(true, "Http:${it.code} ${it.message}")
                }
                is TransactionExceptions.NetworkError -> {
                    liveShowDialog.value = DialogData(true, "Network error")
                }
            }
        }
    }

    fun onActionTransactionClicked(pokemonModel: PokemonModel) {
        navigate(NavData(NAV_DETAIL), pokemonModel)
    }

    fun onActionOnItemSwiped(itemPosition: Int) {
        executeUseCase {
            val transaction = obsListPokemon.value?.get(itemPosition)
            transaction.also {
//                deleteSinglePokemonUseCase.execute(it)
                liveListPokemons.value = getSavedPokemonsUseCase.execute(Unit)
            }
        }
    }
}