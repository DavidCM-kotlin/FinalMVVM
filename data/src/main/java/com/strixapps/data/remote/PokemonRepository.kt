package com.strixapps.data.remote

import com.strixapps.data.BuildConfig.SERVER_URL
import com.strixapps.domain.finalmvvm.exception.TransactionExceptions
import com.strixapps.domain.finalmvvm.model.PokemonModel
import com.strixapps.domain.finalmvvm.repository.GetPokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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

    private val transactionAPI = retrofit.create(pokeAPI::class.java)

//   De aquí no he pasado.....


//    override suspend fun getPokemons(): Result<List<PokemonModel>>{
//        return....
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

    private suspend fun <T> safeApiCall(call: suspend () -> Response<T>): Result<T> {
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