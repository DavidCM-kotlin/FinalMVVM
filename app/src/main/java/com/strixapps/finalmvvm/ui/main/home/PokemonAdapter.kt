package com.strixapps.finalmvvm.ui.main.home

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.strixapps.finalmvvm.R
import com.strixapps.finalmvvm.Utils.*
import com.strixapps.finalmvvm.databinding.ItemPokemonBinding
import com.strixapps.data.database.PokemonModelDB
import com.strixapps.domain.finalmvvm.model.PokemonModel

class PokemonAdapter(private val listener: (PokemonModel) -> Unit) :
    ListAdapter<PokemonModel, PokemonAdapter.PokemonViewHolder>
        (object : DiffUtil.ItemCallback<PokemonModel>() {

        override fun areContentsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean {
            return oldItem.id == newItem.id
        }
    }) {
    inner class PokemonViewHolder(val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemonModel: PokemonModel) {
            with(binding) {
                val context = itemView.context
                pokemonModel.also {

//  Algunos de estas transformaciones se pueden hacer directamente en el modelo cuando
//  se metan los datos.


                    tvID.text = it.id.toString().formatID().appendSymbol()
                    tvName.text = it.name?.capitalized()
                    chipType1.text = it.type1?.capitalized()
                    chipType2.text = it.type2?.capitalized()

                    if (chipType2.text.isEmpty()) {
                        chipType2.visibility = View.GONE
                    } else {
                        chipType2.text = it.type2?.capitalized()
                    }
                    tvWeight.text = it.weight?.weightConverter()?.weightAdd()

                    val formattedID = it.id.toString().formatID()

///////////////////// En esta url las imágenes se ven mejor.

                    val newGlideUrl: String =
                        "https://assets.pokemon.com/assets/cms2/img/pokedex/full/$formattedID.png"

                    Glide.with(itemView.context)
                        .load(it.sprites)
                        .load(newGlideUrl)
                        .into(imageView)

                    ///// Esto tengo que ver otra forma mejor de hacerlo.

                    when (it.type1.toString()) {
                        "bug" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.bug))
                        "dark" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.dark))
                        "dragon" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.dragon))
                        "electric" -> chipType1.chipBackgroundColor = ColorStateList.valueOf(
                            ContextCompat.getColor(context, R.color.electric)
                        )
                        "fairy" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.fairy))
                        "fighting" -> chipType1.chipBackgroundColor = ColorStateList.valueOf(
                            ContextCompat.getColor(context, R.color.fighting)
                        )
                        "fire" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.fire))
                        "flying" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.flying))
                        "ghost" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.ghost))
                        "grass" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.grass))
                        "ground" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.ground))
                        "ice" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.ice))
                        "normal" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.normal))
                        "poison" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.poison))
                        "psychic" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.psychic))
                        "rock" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.rock))
                        "steel" -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.steel))
                        else -> chipType1.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.water))
                    }

                    when (it.type2.toString()) {
                        "bug" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.bug))
                        "dark" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.dark))
                        "dragon" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.dragon))
                        "electric" -> chipType2.chipBackgroundColor = ColorStateList.valueOf(
                            ContextCompat.getColor(
                                context,
                                R.color.electric
                            )
                        )
                        "fairy" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.fairy))
                        "fighting" -> chipType2.chipBackgroundColor = ColorStateList.valueOf(
                            ContextCompat.getColor(
                                context,
                                R.color.fighting
                            )
                        )
                        "fire" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.fire))
                        "flying" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.flying))
                        "ghost" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.ghost))
                        "grass" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.grass))
                        "ground" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.ground))
                        "ice" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.ice))
                        "normal" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.normal))
                        "poison" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.poison))
                        "psychic" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.psychic))
                        "rock" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.rock))
                        "steel" -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.steel))
                        else -> chipType2.chipBackgroundColor =
                            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.water))
                    }
                }
            }
            itemView.setOnClickListener() {
                listener(pokemonModel)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}