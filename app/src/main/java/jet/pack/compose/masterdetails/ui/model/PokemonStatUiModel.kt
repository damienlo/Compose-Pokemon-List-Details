package jet.pack.compose.masterdetails.ui.model

import androidx.annotation.StringRes

data class PokemonStatUiModel(
    @StringRes val nameResId: Int,
     val displayableValue: String,
     val value: Int
)