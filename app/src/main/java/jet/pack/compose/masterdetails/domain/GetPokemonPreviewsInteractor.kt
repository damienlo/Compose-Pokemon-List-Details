package jet.pack.compose.masterdetails.domain

import jet.pack.compose.masterdetails.data.repository.PokemonRepository
import jet.pack.compose.masterdetails.domain.model.PokemonPreview
import jet.pack.compose.masterdetails.domain.model.mapper.PokemonPreviewMapper

class GetPokemonPreviewsInteractor(
    private val repository: PokemonRepository,
    private val mapper: PokemonPreviewMapper
) {
    suspend operator fun invoke(): List<PokemonPreview> {
        val pokemons = repository.getPokemons()
        return pokemons.map { mapper.map(it) }
    }
}