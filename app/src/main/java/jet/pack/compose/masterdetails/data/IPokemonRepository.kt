package jet.pack.compose.masterdetails.data

import jet.pack.compose.masterdetails.data.model.Pokemon
import jet.pack.compose.masterdetails.data.model.PokemonPreview

interface IPokemonRepository {
    @Throws(Exception::class)
    suspend fun getPokemons(): List<PokemonPreview>
    @Throws(Exception::class)
    suspend fun getPokemon(pokemonId: String): Pokemon
}
