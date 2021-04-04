package jet.pack.compose.masterdetails.data.repository

import jet.pack.compose.masterdetails.data.model.PokemonDetailsResponse
import jet.pack.compose.masterdetails.data.model.PokemonMoveResponse
import jet.pack.compose.masterdetails.data.model.PokemonNamedApiResourceResponse
import jet.pack.compose.masterdetails.data.model.PokemonSpeciesResponse
import jet.pack.compose.masterdetails.data.remote.PokemonService
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val service: PokemonService
) {

    suspend fun getPokemons(): List<PokemonNamedApiResourceResponse> {
        val response = service.getPokemons(limit = 151, offset = 0)
        return response.results
    }

    suspend fun getPokemon(id: String): PokemonDetailsResponse {
        return service.getPokemon(id = id)
    }

    suspend fun getSpecies(id: String): PokemonSpeciesResponse {
        return service.getPokemonSpecies(id = id)
    }

    suspend fun getMove(id: String): PokemonMoveResponse {
        return service.getPokemonMove(id = id)
    }
}