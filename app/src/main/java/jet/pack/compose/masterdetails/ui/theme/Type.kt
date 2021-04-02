package jet.pack.compose.masterdetails.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import jet.pack.compose.masterdetails.R

private val PokemonFont = FontFamily(
    Font(R.font.pkmn_rbygsc),
)

val Typography = Typography(
    h4 = TextStyle(
        fontFamily = PokemonFont,
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = PokemonFont,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = PokemonFont,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = PokemonFont,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = PokemonFont,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = PokemonFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = PokemonFont,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    button = TextStyle(
        fontFamily = PokemonFont,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = PokemonFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = PokemonFont,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    )
)