package jet.pack.compose.masterdetails.ui.model.mapper

import jet.pack.compose.masterdetails.domain.model.PokemonType
import jet.pack.compose.masterdetails.ui.model.PokemonTypeUiModel
import javax.inject.Inject

class PokemonTypeUiMapper @Inject constructor() {

    fun map(type: PokemonType): PokemonTypeUiModel = when (type) {
        PokemonType.NORMAL -> PokemonTypeUiModel.NORMAL
        PokemonType.FIRE -> PokemonTypeUiModel.FIGHTING
        PokemonType.WATER -> PokemonTypeUiModel.WATER
        PokemonType.ELECTRIC -> PokemonTypeUiModel.ELECTRIC
        PokemonType.GRASS -> PokemonTypeUiModel.GRASS
        PokemonType.ICE -> PokemonTypeUiModel.ICE
        PokemonType.FIGHTING -> PokemonTypeUiModel.FIGHTING
        PokemonType.POISON -> PokemonTypeUiModel.POISON
        PokemonType.GROUND -> PokemonTypeUiModel.GROUND
        PokemonType.FLYING -> PokemonTypeUiModel.FLYING
        PokemonType.PSYCHIC -> PokemonTypeUiModel.PSYCHIC
        PokemonType.BUG -> PokemonTypeUiModel.BUG
        PokemonType.ROCK -> PokemonTypeUiModel.ROCK
        PokemonType.GHOST -> PokemonTypeUiModel.GHOST
        PokemonType.DRAGON -> PokemonTypeUiModel.DRAGON
        PokemonType.DARK -> PokemonTypeUiModel.DARK
        PokemonType.STEEL -> PokemonTypeUiModel.STEEL
        PokemonType.FAIRY -> PokemonTypeUiModel.FAIRY
        PokemonType.UNKNOWN -> PokemonTypeUiModel.UNKNOWN
    }
}