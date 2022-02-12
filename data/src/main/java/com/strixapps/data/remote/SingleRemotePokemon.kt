package com.strixapps.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.finalmvvm.Utils.cutType1
import com.strixapps.finalmvvm.Utils.cutType2

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
//    @SerializedName("url") val url : String
)

data class Types (
    @SerializedName("slot") val slot : Int,
    @SerializedName("type") val type : Type
)

fun SingleRemotePokemon.toDomain():PokemonModel {
    return PokemonModel(
        id,
        name,
        base_experience.toString(),
        height.toString(),
        weight.toString(),
        sprites.front_default,
        getTypes(types).cutType1().trim(),
        getTypes(types).cutType2().trim()
//        stats[1].base_stat.toString(),
//        stats[2].base_stat.toString(),
//        stats[3].base_stat.toString(),
//        stats[4].base_stat.toString(),
//        stats[4].base_stat.toString()
    )
}

fun getTypes(types: List<Types>):String{
    var jointypes = ""
    for((i, _) in types.withIndex()){
        jointypes += "${types[i].type.name.uppercase()} \n"
    }
    return jointypes
}



