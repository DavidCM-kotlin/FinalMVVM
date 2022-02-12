package com.strixapps.data.remote

import com.strixapps.domain.finalmvvm.exception.TransactionExceptions
import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.domain.finalmvvm.repository.GetPokemonRepository
import okhttp3.OkHttpClient
import org.koin.android.BuildConfig
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class PokemonRepository : GetPokemonRepository {

    private val retrofit: Retrofit =
        Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build()
            )
            .baseUrl(com.strixapps.data.BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val pokeAPI = retrofit.create(pokeAPI::class.java)

    override suspend fun getPokemons(): Result<List<PokemonModel>> {

        val listPokemons = mutableListOf<PokemonModel>()

        // Obtenemos una lista de números aleatorios para obtener los pokemons de Retrofit
        // y que cada vez que obtengamos la lista del servidor no sean los mismos
        var nPok = 1
        while(nPok <= 100) {
            val result = getPokemonById(nPok.toString())
            result.onSuccess { pok ->
                nPok++
                listPokemons.add(pok)
            }.onFailure {
                return Result.failure(it)
            }
        }

//        return Result.success(listPokemons.sortedBy {
//            it.name
//        })
        return Result.success(listPokemons)
    }

    private suspend fun getPokemonById(idPok:String): Result<PokemonModel>{
        return safeApiCall {
            pokeAPI.getPokemons(idPok)
        }.map {
            it.toDomain()
        }
    }

//        val listaTontadas1 = listOf(
//            PokemonModel(
//                1,
//                "bulbasaur",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
//                "grass",
//                "poison",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
////            .map{
////            it.toDomain()
////        }
//
//        val listaTontadas2 = listOf(
//            PokemonModel(
//                4,
//                "charmander",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
//                "fire",
//                "",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
//        val listaTontadas3 = listOf(
//            PokemonModel(
//                6,
//                "charizard",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png",
//                "fire",
//                "flying",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
//        val listaTontadas4 = listOf(
//            PokemonModel(
//                7,
//                "squirtle",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
//                "water",
//                "",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
//        val listaTontadas5 = listOf(
//            PokemonModel(
//                12,
//                "butterfree",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/12.png",
//                "bug",
//                "flying",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
//        val listaTontadas6 = listOf(
//            PokemonModel(
//                25,
//                "pikachu",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
//                "electric",
//                "",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
//        val listaTontadas7 = listOf(
//            PokemonModel(
//                29,
//                "nidoran-f",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/29.png",
//                "poison",
//                "",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
//        val listaTontadas8 = listOf(
//            PokemonModel(
//                35,
//                "clefairy",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png",
//                "fairy",
//                "",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
//        val listaTontadas9 = listOf(
//            PokemonModel(
//                112,
//                "rhydon",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/112.png",
//                "ground",
//                "rock",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
//        val listaTontadas10 = listOf(
//            PokemonModel(
//                144,
//                "articuno",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/144.png",
//                "ice",
//                "flying",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
//        val listaTontadas11 = listOf(
//            PokemonModel(
//                233,
//                "porygon2",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/233.png",
//                "normal",
//                "",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
//        val listaTontadas12 = listOf(
//            PokemonModel(
//                456,
//                "finneon",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/456.png",
//                "water",
//                "",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
//        val listaTontadas13 = listOf(
//            PokemonModel(
//                623,
//                "golurk",
//                "70",
//                "342.8",
//                "342.8",
//                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/623.png",
//                "ground",
//                "ghost",
//                "60",
//                "50",
//                "40",
//                "30",
//                "20",
//                "10"
//            )
//        )
//
////      rhydon, ground, rock
//        listaTontadas9.map {
//            it.toDataDB()
//        }
//
//        val listOfList = listOf(
//            listaTontadas1,
//            listaTontadas2,
//            listaTontadas3,
//            listaTontadas4,
//            listaTontadas5,
//            listaTontadas6,
//            listaTontadas7,
//            listaTontadas8,
//            listaTontadas9,
//            listaTontadas10,
//            listaTontadas11,
//            listaTontadas12,
//            listaTontadas13)
//
//        return Result.success(listOfList.random())
//
////        return Result.success(listaTontadas17)
//    }





//    private suspend fun getPokemonById(idPok:String): Result<PokemonModel>{
//        return safeApiCall {
//            pokeAPI.getPokemons(idPok)
//        }.map {
//            it.toDomain()
//        }
//    }





///////////////////////////////////////   ORIGINAL  //////////////////
/*    @GET("transactions.json")
    suspend fun getTransactions(): Response<List<TransactionDataRemote>>

    override suspend fun getTransactions(): Result<List<TransactionModel>> {
        return safeApiCall {
            transactionAPI.getTransactions()
        }.map {
            it.map {
                it.toDomain()
            }
        }
    }
*/
///////////////////////////////////////     ORIGINAL   //////////////////

    private suspend fun <T> safeApiCall(call: suspend () -> retrofit2.Response<T>): Result<T> {
        return try {
            val response = call()

            when {
                response.isSuccessful -> {
                    Result.success(response.body() as T)
                }
                else -> {
                    Result.failure(TransactionExceptions.HttpError(response.code(), "Http error"))
                }
            }
        } catch (e: Throwable) {
            when (e) {
                is IOException -> Result.failure(TransactionExceptions.NetworkError())
                else -> Result.failure(TransactionExceptions.GenericError(e.message ?: ""))
            }
        }
    }
}