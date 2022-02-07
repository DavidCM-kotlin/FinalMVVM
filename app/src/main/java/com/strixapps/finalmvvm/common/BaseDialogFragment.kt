package com.strixapps.finalmvvm.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseDialogFragment<T: ViewBinding> : DialogFragment() {

    private var _binding  : T? = null

    protected val binding
        get() =  _binding!!

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = provideBinding(inflater,container)
        return binding.root
    }

    abstract fun provideBinding(inflater: LayoutInflater, container: ViewGroup?):T


    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}