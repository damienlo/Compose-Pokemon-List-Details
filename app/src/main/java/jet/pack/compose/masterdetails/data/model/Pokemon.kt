package jet.pack.compose.masterdetails.data.model

data class Pokemon(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val mainColor: String,
    val height: Int,
    val weight: Int,
    val moves: List<Move>,
    val stats: List<Stat>,
    val types: List<PokemonType>
)

data class Move(
    val name: String,
    val description: String,
    val accuracy: Int?,
    val power: Int?,
    val type: PokemonType
)

data class Stat(
    val name: String,
    val value: Int
)
