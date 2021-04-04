package jet.pack.compose.masterdetails.ui.components

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@Composable
fun RotatingPokeball(modifier: Modifier = Modifier) {
    val rotateAnimation = rememberInfiniteTransition()
    val progress by rotateAnimation.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 4350,
                easing = FastOutLinearInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    Pokeball(modifier = modifier.rotate(degrees = progress))
}

@Composable
fun Pokeball(modifier: Modifier = Modifier) {
    val density = LocalDensity.current
    Canvas(modifier = modifier, onDraw = {
        val borderThicknessPx = with(density) { (size.minDimension.toDp() / 19).toPx() }
        // Borders
        drawCircle(
            color = Color(0xFF222224),
            radius = size.minDimension / 2f,
            center = center
        )
        // Top
        drawArc(
            brush = Brush.sweepGradient(
                listOf(
                    Color(0XFFEE1515),
                    Color(0XFFF14343)
                )
            ),
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(borderThicknessPx, borderThicknessPx),
            size = Size(size.width - 2f * borderThicknessPx, size.height - 2f * borderThicknessPx)
        )
        // Bottom
        drawArc(
            brush = Brush.sweepGradient(
                listOf(
                    Color(0XFFFFFFFF),
                    Color(0XFFDDB6B6)
                )
            ),
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(borderThicknessPx, borderThicknessPx),
            size = Size(size.width - 2f * borderThicknessPx, size.height - 2f * borderThicknessPx)
        )
        // Bar
        drawRect(
            color = Color(0xFF222224),
            topLeft = Offset(0f, size.height / 2),
            size = Size(size.width, borderThicknessPx)
        )
        // Inner Circle Border
        drawCircle(
            color = Color(0xFF222224),
            radius = (size.minDimension / 8f) + borderThicknessPx,
            center = center
        )
        // Inner Circle
        drawCircle(
            color = Color.White,
            radius = (size.minDimension / 8f),
            center = center
        )
    })
}

@Preview
@Composable
fun PokeballLightPreview() {
    MasterDetailsTheme {
        Pokeball(Modifier.size(96.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PokeballDarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        Pokeball(Modifier.size(96.dp))
    }
}