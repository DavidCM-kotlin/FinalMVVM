package com.strixapps.finalmvvm.ui.main.userSettings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserSettingsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is User Settings Fragment"
    }
    val text: LiveData<String> = _text
}