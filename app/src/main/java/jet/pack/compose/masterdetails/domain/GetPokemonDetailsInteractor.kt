package jet.pack.compose.masterdetails.domain

import jet.pack.compose.masterdetails.data.model.PokemonDetailsResponse
import jet.pack.compose.masterdetails.data.model.PokemonMoveResponse
import jet.pack.compose.masterdetails.data.model.PokemonSpeciesResponse
import jet.pack.compose.masterdetails.data.repository.PokemonRepository
import jet.pack.compose.masterdetails.domain.model.Pokemon
import jet.pack.compose.masterdetails.domain.model.mapper.PokemonIdExtractorUtils.extractId
import jet.pack.compose.masterdetails.domain.model.mapper.PokemonMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPokemonDetailsInteractor @Inject constructor(
    private val repository: PokemonRepository,
    private val mapper: PokemonMapper
) {
    suspend operator fun invoke(pokemonId: String) : Pokemon {
        val pokemon = repository.getPokemon(id = pokemonId)
        val species = getSpecies(pokemon)
        val moves = getStarterMoves(pokemon)
        return mapper.map(pokemon, species, moves)
    }

    private suspend fun getStarterMoves(pokemon: PokemonDetailsResponse): List<PokemonMoveResponse> =
        withContext(Dispatchers.IO) {
            val startedMoveIds = pokemon.moves
                .filter { it.versionGroupDetails.first().learnedAt == 1 }
                .map { it.move.url.extractId() }
            val moveRequests = startedMoveIds.map {
                async { repository.getMove(it) }
            }
            moveRequests.awaitAll()
        }

    private suspend fun getSpecies(pokemon: PokemonDetailsResponse) : PokemonSpeciesResponse {
        val speciesId = pokemon.species.url.extractId()
        return repository.getSpecies(speciesId)
    }

}