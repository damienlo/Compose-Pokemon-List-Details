package jet.pack.compose.masterdetails.ui.model

data class PokemonMoveUiModel(
    val name: String,
    val description: String,
    val accuracy: String,
    val power: String,
    val type: PokemonTypeUiModel
)