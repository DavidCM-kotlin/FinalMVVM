package com.strixapps.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.android.BuildConfig

@Database(entities = [(PokemonModelDB::class)], version = 1)

abstract class PokemonDatabase: RoomDatabase() {

//    BASE DE DATOS DE PRUEBA CON ALGUNOS POKEMONS DE EJEMPLO, PARA VER GRÁFICOS,
//    SI SE CARGAN LAS IMAGENES DESDE GLIDE Y SI CARGAN LOS DATOS DE ROOM.

//    companion object {
//        private const val DATABASE_NAME = "room_database"
//        private const val DATABASE_DIR = "database/room_database.db"
//
//        fun getInstance(context: Context): PokemonDatabase {
//            return Room
//                .databaseBuilder(context, PokemonDatabase::class.java, DATABASE_NAME)
//                .createFromAsset(DATABASE_DIR)
//                .build()
//        }
//    }
    abstract fun pokemonDao() : PokemonDao
}


