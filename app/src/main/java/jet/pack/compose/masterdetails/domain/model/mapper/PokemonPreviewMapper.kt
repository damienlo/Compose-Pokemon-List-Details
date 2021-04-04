package jet.pack.compose.masterdetails.domain.model.mapper

import jet.pack.compose.masterdetails.data.model.PokemonNamedApiResourceResponse
import jet.pack.compose.masterdetails.domain.model.mapper.PokemonIdExtractorUtils.extractId
import jet.pack.compose.masterdetails.domain.model.PokemonPreview
import java.util.*
import javax.inject.Inject

class PokemonPreviewMapper @Inject constructor() {

    fun map(pokemon: PokemonNamedApiResourceResponse): PokemonPreview =
        PokemonPreview(
            id = pokemon.url.extractId(),
            name = pokemon.name.capitalize(Locale.getDefault()),
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.url.extractId()}.png"
        )
}