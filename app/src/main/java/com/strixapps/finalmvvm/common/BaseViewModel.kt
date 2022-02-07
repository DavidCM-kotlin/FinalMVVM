package com.strixapps.finalmvvm.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.finalmvvm.ui.dialog.DialogData
import com.strixapps.finalmvvm.ui.main.MainViewModel
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected val liveShowLoading = MutableLiveData<Boolean>()
    val obsShowLoading: LiveData<Boolean> = liveShowLoading

    protected val liveShowDialog = MutableLiveData<DialogData>()
    val obsShowDialog:LiveData<DialogData> = liveShowDialog

    protected val liveShowMessage = SingleLiveEvent<String>()
    val obsShowMessage:LiveData<String> = liveShowMessage

    protected val liveNavigation = SingleLiveEvent<NavData?>()
    val obsNavigate = liveNavigation

    protected lateinit var mainViewModel: MainViewModel

    fun attachMainViewModel(mainViewModel: MainViewModel){
        this.mainViewModel = mainViewModel
    }

    protected fun showLoading(){
        liveShowLoading.value = true
    }

    protected fun hideLoading(){
        liveShowLoading.value = false
    }

    protected fun showMessage(message:String){
        liveShowMessage.value = message
    }

    protected fun showDialog(dialogData: DialogData){
        liveShowDialog.value = dialogData
    }

    open fun onActionErrorAcceptClicked() {
        liveShowDialog.value = DialogData(show = false)
    }

    protected fun navigate(navData: NavData, pokemonModel: PokemonModel){
        liveNavigation.value = navData
    }

    protected fun executeUseCase(
        exceptionAction : (suspend ((Throwable)->Unit))?=null,
        finalAction : (suspend  ()->Unit)?=null,
        usecaseAction: suspend ()->Unit
    ){
        viewModelScope.launch {
            try {
                usecaseAction.invoke()
            }
            catch (e:Throwable){
                exceptionAction?.invoke(e)
            }
            finally {
                finalAction?.invoke()
            }
        }
    }

    fun onInit() {
        onInitialization()
    }

    abstract fun onInitialization()

}