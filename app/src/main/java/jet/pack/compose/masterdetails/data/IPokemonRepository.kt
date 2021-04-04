package jet.pack.compose.masterdetails.data

import jet.pack.compose.masterdetails.data.model.Pokemon
import jet.pack.compose.masterdetails.data.model.PokemonPreview

interface IPokemonRepository {
    suspend fun getPokemons(): List<PokemonPreview>
    suspend fun getPokemon(pokemonId: String): Pokemon
}
