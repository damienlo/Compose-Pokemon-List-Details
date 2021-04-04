package jet.pack.compose.masterdetails.ui.model.mapper

import jet.pack.compose.masterdetails.R
import jet.pack.compose.masterdetails.domain.model.Stat
import jet.pack.compose.masterdetails.ui.model.PokemonStatUiModel

class PokemonStatUiMapper {

    fun map(stat: Stat): PokemonStatUiModel = PokemonStatUiModel(
        nameResId = stat.name.toStatResId(),
        displayableValue = "%03d".format(stat.value),
        value = stat.value
    )

    private fun String.toStatResId(): Int = when (this) {
        "hp" -> R.string.pokemon_stat_hp
        "attack" -> R.string.pokemon_stat_atk
        "defense" -> R.string.pokemon_stat_def
        "special-attack" -> R.string.pokemon_stat_satk
        "special-defense" -> R.string.pokemon_stat_sdef
        "speed" -> R.string.pokemon_stat_spd
        else -> R.string.pokemon_generic_err
    }
}