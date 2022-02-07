package com.strixapps.finalmvvm.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.strixapps.finalmvvm.common.BaseDialogFragment
import com.strixapps.finalmvvm.databinding.FragmentDialogErrorBinding

class ErrorDialogFragment : BaseDialogFragment<FragmentDialogErrorBinding>() {

    companion object{
        fun newInstance(): ErrorDialogFragment{
            return ErrorDialogFragment()
        }
    }

    private var acceptListener: (()->Unit)?=null
    private var message:String?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDialogErrorDescription.text = message
        binding.btDialogErrorTitle.setOnClickListener {
            acceptListener?.invoke()
        }
    }

    fun show(fragmentManager: FragmentManager,tag:String,message:String,acceptListener:()->Unit){
        (fragmentManager.findFragmentByTag(tag) as? ErrorDialogFragment)?.dismiss()
        this.message = message
        this.acceptListener = acceptListener
        show(fragmentManager,tag)
    }

    fun dismiss(fragmentManager: FragmentManager){
        (fragmentManager.findFragmentByTag(tag) as? ErrorDialogFragment)?.also {
            it.dismiss()
        }
    }

    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDialogErrorBinding {
        return FragmentDialogErrorBinding.inflate(inflater,container,false)
    }
}