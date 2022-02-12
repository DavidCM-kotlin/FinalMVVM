package com.strixapps.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.strixapps.domain.finalmvvm.model.PokemonModel
import java.io.Serializable

@Entity(tableName = PokemonModelDB.TABLENAME)
data class PokemonModelDB(
    @PrimaryKey
    @ColumnInfo(name = ID) val id: Int,
    @ColumnInfo(name = NAME) val name: String?,
    @ColumnInfo(name = BASEEXPERIENCE) val base_experience: String?,
    @ColumnInfo(name = HEIGHT) val height: String?,
    @ColumnInfo(name = WEIGHT) val weight: String?,
    @ColumnInfo(name = SPRITES) val sprites: String?,
    @ColumnInfo(name = TYPE1) val type1: String?,
    @ColumnInfo(name = TYPE2) val type2: String?
//    @ColumnInfo(name = HP) val hp: String?,
//    @ColumnInfo(name = ATTACK) val attack: String?,
//    @ColumnInfo(name = DEFENSE) val defense: String?,
//    @ColumnInfo(name = SPATTACK) val special_attack: String?,
//    @ColumnInfo(name = SPDEFENSE) val special_defense: String?,
//    @ColumnInfo(name = SPEED) val speed: String?
) : Serializable {

    companion object TABLE {
        const val TABLENAME = "table_pokemons"
        const val ID = "id"
        const val NAME = "name"
        const val BASEEXPERIENCE = "base_experience"
        const val HEIGHT = "height"
        const val WEIGHT = "weight"
        const val SPRITES = "sprites"
        const val TYPE1 = "type1"
        const val TYPE2 = "type2"
//        const val HP = "hp"
//        const val ATTACK = "attack"
//        const val DEFENSE = "defense"
//        const val SPATTACK = "special-attack"
//        const val SPDEFENSE = "special-defense"
//        const val SPEED = "speed"
    }
}

fun PokemonModel.toDataDB():PokemonModelDB{
    return PokemonModelDB(
        id, name, base_experience, height, weight, sprites, type1, type2)
}


fun PokemonModelDB.toDomain():PokemonModel{
    return PokemonModel(id,name,base_experience,height, weight, sprites, type1, type2)
}


//fun PokemonModel.toDataDB():PokemonModelDB{
//    return PokemonModelDB(
//        id, name, base_experience, height, weight, sprites, type1, type2, hp, attack, defense, special_attack, special_defense, speed)
//}
//
//fun PokemonModelDB.toDomain():PokemonModel{
//    return PokemonModel(id,name, base_experience,height,weight,sprites,type1,type2,hp,attack,defense,special_attack,special_defense, speed)
//}