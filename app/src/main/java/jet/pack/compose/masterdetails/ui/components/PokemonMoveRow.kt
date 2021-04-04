package jet.pack.compose.masterdetails.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jet.pack.compose.masterdetails.ui.model.PokemonMoveUiModel
import jet.pack.compose.masterdetails.ui.model.PokemonTypeUiModel
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@Composable
fun PokemonMoveRow(move: PokemonMoveUiModel, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .padding(vertical = 12.dp)
        ) {
            Text(
                text = move.name,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = move.description,
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        CircleColored(
            color = if (isSystemInDarkTheme()) move.type.darkColor else move.type.lightColor,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
private fun CircleColored(color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(32.dp)
            .clip(shape = CircleShape)
            .background(color)
    )
}

@Preview
@Composable
fun PokemonMoveRowLightPreview() {
    val move = PokemonMoveUiModel("Whip", "whip", "40", "60", PokemonTypeUiModel.GRASS)
    MasterDetailsTheme {
        PokemonMoveRow(move)
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonMoveRowDarkPreview() {
    val move = PokemonMoveUiModel("Whip", "whip", "40", "60", PokemonTypeUiModel.GRASS)
    MasterDetailsTheme(darkTheme = true) {
        PokemonMoveRow(move)
    }
}