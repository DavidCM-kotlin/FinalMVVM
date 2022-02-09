package com.strixapps.finalmvvm.ui.main.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.finalmvvm.common.BaseFragment
import com.strixapps.finalmvvm.databinding.FragmentDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding, DetailsViewModel>() {

    override val vm: DetailsViewModel by viewModel()

    val args: DetailsFragmentArgs by navArgs()

    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsBinding {
        return FragmentDetailsBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemon = args.pokemon
        vm.onAttachTransaction(pokemon)
        observeData(vm.obsPokemon,::onObservePokemon)
    }

    private fun onObservePokemon(pokemonModel: PokemonModel) {
        binding.textDetails.text = pokemonModel.id.toString()
        binding.textDetails2.text = pokemonModel.name
        binding.textDetails3.text = pokemonModel.base_experience.toString()
    }
}