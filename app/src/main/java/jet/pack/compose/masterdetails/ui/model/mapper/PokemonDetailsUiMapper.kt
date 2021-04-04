package jet.pack.compose.masterdetails.ui.model.mapper

import jet.pack.compose.masterdetails.data.model.Pokemon
import jet.pack.compose.masterdetails.ui.model.PokemonDetailsUiModel
import java.util.Locale
import javax.inject.Inject

class PokemonDetailsUiMapper @Inject constructor(
    private val typeUiMapper: PokemonTypeUiMapper,
    private val statUiMapper: PokemonStatUiMapper,
    private val moveUiMapper: PokemonMoveUiMapper
) {

    fun map(pokemon: Pokemon): PokemonDetailsUiModel = PokemonDetailsUiModel(
        id = pokemon.id,
        name = pokemon.name.capitalize(Locale.getDefault()),
        description = pokemon.description.removeAllNewLines(),
        imageUrl = pokemon.imageUrl,
        height = pokemon.height,
        weight = pokemon.weight,
        types = pokemon.types.map { typeUiMapper.map(it) },
        stats = pokemon.stats.map { statUiMapper.map(it) },
        moves = pokemon.moves.map { moveUiMapper.map(it) }
    )

    private fun String.removeAllNewLines() =
        replace("\n", " ")
            .replace("\r\n", " ")
            .replace("\r", " ")
}