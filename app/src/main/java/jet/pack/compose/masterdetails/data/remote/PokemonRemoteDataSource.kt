package jet.pack.compose.masterdetails.data.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory

object PokemonRemoteDataSource {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val pokemonService: PokemonService = retrofit.create(PokemonService::class.java)
}