package com.strixapps.finalmvvm.common

import android.text.TextWatcher
import android.widget.EditText

fun EditText.setText(text:String, watcher: TextWatcher){
    removeTextChangedListener(watcher)
    if(text!=this.text.toString()) {
        setText(text)
        setSelection(text.length)
    }
    addTextChangedListener(watcher)
}