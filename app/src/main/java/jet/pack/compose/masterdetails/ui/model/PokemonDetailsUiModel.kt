package jet.pack.compose.masterdetails.ui.model

data class PokemonDetailsUiModel(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val height: Int,
    val weight: Int,
    val types: List<PokemonTypeUiModel>,
    val stats: List<PokemonStatUiModel>,
    val moves: List<PokemonMoveUiModel>
)
