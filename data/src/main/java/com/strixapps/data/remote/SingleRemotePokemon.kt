package com.strixapps.data.remote

import com.google.gson.annotations.SerializedName
import com.strixapps.domain.finalmvvm.model.PokemonModel

data class SingleRemotePokemon (
    @SerializedName("base_experience") val base_experience : Int,
    @SerializedName("height") val height : Int,
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("sprites") val sprites : Sprites,
    @SerializedName("stats") val stats : List<Stats>,
    @SerializedName("types") val types : List<Types>,
    @SerializedName("weight") val weight : Int
)

data class Sprites (
    @SerializedName("front_default") val front_default : String,
)

data class Stat (
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String
)

data class Stats (
    @SerializedName("base_stat") val base_stat : Int,
    @SerializedName("effort") val effort : Int,
    @SerializedName("stat") val stat : Stat
)

data class Type (
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String
)

data class Types (
    @SerializedName("slot") val slot : Int,
    @SerializedName("type") val type : Type
)

fun SingleRemotePokemon.toDomain():PokemonModel {
    return PokemonModel(
        id = id,
        name = name,
        base_experience = base_experience.toString(),
        height = height.toString(),
        weight = weight.toString(),
        sprites = sprites.front_default,
        type1 = types[0].type.name,
        type2 = types[1].type.name,
        hp = stats[0].base_stat.toString(),
        attack = stats[1].base_stat.toString(),
        defense = stats[2].base_stat.toString(),
        special_attack = stats[3].base_stat.toString(),
        special_defense = stats[4].base_stat.toString(),
        speed = stats[4].base_stat.toString()
    )
}