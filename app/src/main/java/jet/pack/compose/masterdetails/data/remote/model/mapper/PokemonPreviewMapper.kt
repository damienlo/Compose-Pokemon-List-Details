package jet.pack.compose.masterdetails.data.remote.model.mapper

import jet.pack.compose.masterdetails.data.remote.model.PokemonNamedApiResourceResponse
import jet.pack.compose.masterdetails.data.remote.model.mapper.PokemonIdExtractorUtils.extractId
import jet.pack.compose.masterdetails.data.model.PokemonPreview
import java.util.Locale
import javax.inject.Inject

class PokemonPreviewMapper @Inject constructor() {

    fun map(pokemon: PokemonNamedApiResourceResponse): PokemonPreview =
        PokemonPreview(
            id = pokemon.url.extractId(),
            name = pokemon.name.capitalize(Locale.getDefault()),
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.url.extractId()}.png"
        )
}