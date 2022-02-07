package com.strixapps.finalmvvm.ui.main

import androidx.lifecycle.MutableLiveData
import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.finalmvvm.common.BaseViewModel
import com.strixapps.finalmvvm.common.NavData


class MainViewModel : BaseViewModel() {

    private val liveShowFab = MutableLiveData<Boolean>()
    val obsShowFab = liveShowFab

    fun showFab(show:Boolean){
        liveShowFab.value = show
    }
//
//    fun navigateBack(){
//        liveNavigation.value = null
//    }

    companion object{
        const val NAV_POKEDEX = 0
        const val NAV_FAVORITES = 1
        const val NAV_SETTINGS = 2
    }

    override fun onInitialization() {
    }

    fun onActionTransactionClicked() {
//        navigate(NavData(NAV_TRANSACTION), pokemonmodel)
    }

    fun onActionProfileClicked() {
//        navigate(NavData(NAV_PROFILE), pokemonModel)
    }

}