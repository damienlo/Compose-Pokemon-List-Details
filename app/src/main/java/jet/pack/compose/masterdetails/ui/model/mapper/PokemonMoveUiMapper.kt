package jet.pack.compose.masterdetails.ui.model.mapper

import jet.pack.compose.masterdetails.data.model.Move
import jet.pack.compose.masterdetails.ui.model.PokemonMoveUiModel
import java.util.Locale
import javax.inject.Inject

class PokemonMoveUiMapper @Inject constructor(
    private val typeUiMapper: PokemonTypeUiMapper
) {

    fun map(move: Move): PokemonMoveUiModel = PokemonMoveUiModel(
        name = move.name.capitalize(Locale.getDefault()),
        description = move.description,
        accuracy = move.accuracy?.toString() ?: "-",
        power = move.power?.toString() ?: "-",
        type = typeUiMapper.map(move.type)
    )
}