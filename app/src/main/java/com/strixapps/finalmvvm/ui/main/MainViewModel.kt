package com.strixapps.finalmvvm.ui.main

import androidx.lifecycle.MutableLiveData
import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.finalmvvm.common.BaseViewModel
import com.strixapps.finalmvvm.common.NavData


class MainViewModel : BaseViewModel() {

    private val liveShowFab = MutableLiveData<Boolean>()
    val obsShowFab = liveShowFab

    override fun onInitialization() {
    }

    fun showFab(show:Boolean){
        liveShowFab.value = show
    }

    fun navigateBack(){
        liveNavigation.value = null
    }

}