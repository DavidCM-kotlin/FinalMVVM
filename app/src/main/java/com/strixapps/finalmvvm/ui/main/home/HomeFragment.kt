package com.strixapps.finalmvvm.ui.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.LOG
import com.strixapps.finalmvvm.common.BaseFragment
import com.strixapps.finalmvvm.common.NavData
import com.strixapps.finalmvvm.databinding.FragmentHomeBinding
import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.finalmvvm.R
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val vm: HomeViewModel by sharedViewModel()

    private val adapter by lazy {
        PokemonAdapter {
            vm.onActionTransactionClicked(it)
        }
    }

    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupBinding()
    }

//    private fun setupRecycler() {
//        with(binding) {
//            pokemonRV.layoutManager =
//                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//            pokemonRV.adapter = adapter
//            val deleteHelper = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
//                override fun onMove(
//                    recyclerView: RecyclerView,
//                    viewHolder: RecyclerView.ViewHolder,
//                    target: RecyclerView.ViewHolder
//                ): Boolean {
//                    return true
//                }
//                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                    vm.onActionOnItemSwiped(viewHolder.adapterPosition)
//                }
//            }
//            ItemTouchHelper(deleteHelper).attachToRecyclerView(pokemonRV)
//        }
//    }

    private fun setupRecycler() {
        with(binding) {
            pokemonRV.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            pokemonRV.adapter = adapter
            val deleteHelper = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return true
                }
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    Log.d("adsfas", viewHolder.adapterPosition.toString())
//                    LOG.i("adsfas", viewHolder.adapterPosition.toString())
                    vm.onActionOnItemSwiped(viewHolder.adapterPosition)
                }
            }
            ItemTouchHelper(deleteHelper).attachToRecyclerView(pokemonRV)
        }
    }




//
//    override fun onNavigate(navData: NavData) {
//        when(navData.id){
//            HomeViewModel.NAV_DETAIL ->{
//                val pokemon = navData.data as PokemonModel
//                findNavController().navigate(HomeFragmentDirections.actionNavHomeToDetailsFragment(pokemon))
//            }
//        }
//    }

//
override fun onNavigate(navData: NavData) {
//    when(navData.id){
//        HomeViewModel.NAV_DETAIL ->{

            val pokemon = navData.data as PokemonModel
            findNavController().navigate(HomeFragmentDirections.actionNavHomeToDetailsFragment(pokemon))

    }

//    private fun navigateToPlant(plantId: String) {
//
//        val args = navData.data as PokemonModel
//        findNavController().navigate(nav_graph.action.to_plant_detail, args)
//    }
//

    private fun setupBinding() {
        observeData(vm.obsListPokemon, ::onObserveList)
    }

    private fun onObserveList(list: List<PokemonModel>) {
        adapter.submitList(list)
    }
}