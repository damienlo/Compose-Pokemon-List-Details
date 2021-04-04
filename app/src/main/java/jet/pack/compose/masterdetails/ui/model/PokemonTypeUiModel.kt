package jet.pack.compose.masterdetails.ui.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import jet.pack.compose.masterdetails.R

enum class PokemonTypeUiModel(
    @StringRes val nameResId: Int,
    val lightColor: Color,
    val darkColor: Color
) {
    NORMAL(
        R.string.pokemon_type_normal,
        Color(0XFFAAAA99),
        Color(0XFFAAAA99).copy(alpha = .5f)
    ),
    FIRE(
        R.string.pokemon_type_fire,
        Color(0XFFFF4422),
        Color(0XFFFF4422).copy(alpha = .5f)
    ),
    WATER(
        R.string.pokemon_type_water,
        Color(0XFF3399FF),
        Color(0XFF3399FF).copy(alpha = .5f)
    ),
    ELECTRIC(
        R.string.pokemon_type_electric,
        Color(0XFFFFCC33),
        Color(0XFFFFCC33).copy(alpha = .5f)
    ),
    GRASS(
        R.string.pokemon_type_grass,
        Color(0XFF77CC55),
        Color(0XFF77CC55).copy(alpha = .5f)
    ),
    ICE(
        R.string.pokemon_type_ice,
        Color(0XFF66CCFF),
        Color(0XFF66CCFF).copy(alpha = .5f)
    ),
    FIGHTING(
        R.string.pokemon_type_fighting,
        Color(0XFFBB5544),
        Color(0XFFBB5544).copy(alpha = .5f)
    ),
    POISON(
        R.string.pokemon_type_poison,
        Color(0XFFAA5599),
        Color(0XFFAA5599).copy(alpha = .5f)
    ),
    GROUND(
        R.string.pokemon_type_ground,
        Color(0XFFDDBB55),
        Color(0XFFDDBB55).copy(alpha = .5f)
    ),
    FLYING(
        R.string.pokemon_type_flying,
        Color(0XFF8899FF),
        Color(0XFF8899FF).copy(alpha = .5f)
    ),
    PSYCHIC(
        R.string.pokemon_type_psychic,
        Color(0XFFff5599),
        Color(0XFFff5599).copy(alpha = .5f)
    ),
    BUG(
        R.string.pokemon_type_bug,
        Color(0XFFAABB22),
        Color(0XFFAABB22).copy(alpha = .5f)
    ),
    ROCK(
        R.string.pokemon_type_rock,
        Color(0XFFBBAA66),
        Color(0XFFBBAA66).copy(alpha = .5f)
    ),
    GHOST(
        R.string.pokemon_type_ghost,
        Color(0XFF6666BB),
        Color(0XFF6666BB).copy(alpha = .5f)
    ),
    DRAGON(
        R.string.pokemon_type_dragon,
        Color(0XFF7766EE),
        Color(0XFF7766EE).copy(alpha = .5f)
    ),
    DARK(
        R.string.pokemon_type_dark,
        Color(0XFF775544),
        Color(0XFF775544).copy(alpha = .5f)
    ),
    STEEL(
        R.string.pokemon_type_steel,
        Color(0XFFAAAABB),
        Color(0XFFAAAABB).copy(alpha = .5f)
    ),
    FAIRY(
        R.string.pokemon_type_fairy,
        Color(0XFFEE99EE),
        Color(0XFFEE99EE).copy(alpha = .5f)
    ),
    UNKNOWN(
        R.string.pokemon_type_unknown,
        Color.Magenta,
        Color.Magenta.copy(alpha = .5f)
    );
}