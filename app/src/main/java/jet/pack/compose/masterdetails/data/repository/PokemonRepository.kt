package jet.pack.compose.masterdetails.data.repository

import jet.pack.compose.masterdetails.data.remote.model.PokemonDetailsResponse
import jet.pack.compose.masterdetails.data.remote.model.PokemonMoveResponse
import jet.pack.compose.masterdetails.data.remote.model.PokemonSpeciesResponse
import jet.pack.compose.masterdetails.data.remote.model.mapper.PokemonIdExtractorUtils.extractId
import jet.pack.compose.masterdetails.data.remote.model.mapper.PokemonMapper
import jet.pack.compose.masterdetails.data.remote.model.mapper.PokemonPreviewMapper
import jet.pack.compose.masterdetails.data.remote.PokemonService
import jet.pack.compose.masterdetails.data.IPokemonRepository
import jet.pack.compose.masterdetails.data.model.Pokemon
import jet.pack.compose.masterdetails.data.model.PokemonPreview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val service: PokemonService,
    private val previewMapper: PokemonPreviewMapper,
    private val pokemonMapper: PokemonMapper
) : IPokemonRepository {

    override suspend fun getPokemons(): List<PokemonPreview> {
        val pokemons = service.getPokemons(limit = 151, offset = 0).results
        return pokemons.map { previewMapper.map(it) }
    }

    override suspend fun getPokemon(pokemonId: String): Pokemon {
        val pokemon = service.getPokemon(id = pokemonId)
        val species = getSpecies(pokemon)
        val moves = getStarterMoves(pokemon)
        return pokemonMapper.map(pokemon, species, moves)
    }

    private suspend fun getSpecies(pokemon: PokemonDetailsResponse): PokemonSpeciesResponse {
        val speciesId = pokemon.species.url.extractId()
        return service.getPokemonSpecies(speciesId)
    }

    private suspend fun getStarterMoves(pokemon: PokemonDetailsResponse): List<PokemonMoveResponse> =
        withContext(Dispatchers.IO) {
            val startedMoveIds = pokemon.moves
                .filter { it.versionGroupDetails.first().learnedAt == 1 }
                .map { it.move.url.extractId() }
            val moveRequests = startedMoveIds.map { moveId ->
                async { service.getPokemonMove(moveId) }
            }
            moveRequests.awaitAll()
        }
}