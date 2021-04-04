package jet.pack.compose.masterdetails.ui.model.mapper

import jet.pack.compose.masterdetails.data.model.PokemonPreview
import jet.pack.compose.masterdetails.ui.model.PokemonPreviewUiModel
import java.util.Locale
import javax.inject.Inject

class PokemonPreviewUiMapper @Inject constructor() {

    fun map(pokemonPreview: PokemonPreview): PokemonPreviewUiModel =
        PokemonPreviewUiModel(
            id = pokemonPreview.id,
            name = pokemonPreview.name.capitalize(Locale.getDefault()),
            imageUrl = pokemonPreview.imageUrl
        )
}