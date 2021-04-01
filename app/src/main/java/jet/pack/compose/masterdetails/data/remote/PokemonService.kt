package jet.pack.compose.masterdetails.data.remote

import jet.pack.compose.masterdetails.data.model.PokemonDetailsResponse
import jet.pack.compose.masterdetails.data.model.PokemonMoveResponse
import jet.pack.compose.masterdetails.data.model.PokemonPaginatedResponse
import jet.pack.compose.masterdetails.data.model.PokemonSpeciesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): PokemonPaginatedResponse

    @GET("pokemon/{id}")
    suspend fun getPokemon(
        @Path("id") id: String
    ): PokemonDetailsResponse

    @GET("pokemon-species/{id}")
    suspend fun getPokemonSpecies(
        @Path("id") id: String
    ): PokemonSpeciesResponse

    @GET("move/{id}")
    suspend fun getPokemonMove(
        @Path("id") id: String
    ): PokemonMoveResponse

}