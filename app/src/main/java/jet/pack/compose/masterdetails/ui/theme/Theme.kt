package jet.pack.compose.masterdetails.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = LightBlue500,
    primaryVariant = DeepBlue.copy(alpha = .8f),
    secondary = NiceYellow500,
    background = DarkGray,
    surface = DarkGray500,
    onPrimary = Color.White.copy(alpha = .8f),
    onSecondary = DarkGray,
    onBackground = Color.White.copy(alpha = .8f),
    onSurface = Color.White.copy(alpha = .8f),
    error = ElectricRed500,
    onError = DarkGray
)

private val LightColorPalette = lightColors(
    primary = LightBlue,
    primaryVariant = DeepBlue,
    secondary = NiceYellow,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = DarkGray.copy(alpha = .8f),
    onBackground = DarkGray.copy(alpha = .8f),
    onSurface = DarkGray.copy(alpha = .8f),
    error = ElectricRed,
    onError = Color.White
)

@Composable
fun MasterDetailsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}