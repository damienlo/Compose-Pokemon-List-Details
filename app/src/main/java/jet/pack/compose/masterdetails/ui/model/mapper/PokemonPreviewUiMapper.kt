package jet.pack.compose.masterdetails.ui.model.mapper

import jet.pack.compose.masterdetails.domain.model.PokemonPreview
import jet.pack.compose.masterdetails.ui.model.PokemonPreviewUiModel
import java.util.*

class PokemonPreviewUiMapper {

    fun map(pokemonPreview: PokemonPreview): PokemonPreviewUiModel =
        PokemonPreviewUiModel(
            id = pokemonPreview.id,
            name = pokemonPreview.name.capitalize(Locale.getDefault()),
            imageUrl = pokemonPreview.imageUrl
        )
}