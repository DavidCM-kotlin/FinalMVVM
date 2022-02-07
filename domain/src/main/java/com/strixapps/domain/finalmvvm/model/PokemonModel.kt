package com.strixapps.domain.finalmvvm.model

import java.io.Serializable

data class PokemonModel (
        val id:Int,
        val name:String?,
        val base_experience:String?,
        val height:String?,
        val weight:String?,
        val sprites:String?,
        val type1:String?,
        val type2:String?,
        val hp:String?,
        val attack:String?,
        val defense:String?,
        val special_attack:String?,
        val special_defense:String?,
        val speed:String?
        ):Serializable