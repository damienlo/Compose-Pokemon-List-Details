package jet.pack.compose.masterdetails.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jet.pack.compose.masterdetails.R
import jet.pack.compose.masterdetails.ui.model.PokemonStatUiModel
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@Composable
fun PokemonStatRow(stat: PokemonStatUiModel, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(stat.nameResId),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.weight(.15f)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = stat.displayableValue,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.primary,
            modifier = Modifier.weight(.1f)
        )
        Spacer(modifier = Modifier.width(4.dp))
        PokemonStatBar(stat = stat, modifier = Modifier.weight(.35f))
    }
}

@Composable
private fun PokemonStatBar(stat: PokemonStatUiModel, modifier: Modifier = Modifier) {
    val maxStatVal = 155f
    LinearProgressIndicator(
        progress = stat.value / maxStatVal,
        color = MaterialTheme.colors.primary,
        modifier = modifier.height(24.dp)
    )
}

@Preview
@Composable
fun PokemonStatRowLightPreview() {
    val stat = PokemonStatUiModel(R.string.pokemon_stat_hp, "065", 65)
    MasterDetailsTheme {
        PokemonStatRow(stat)
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonStatRowDarkPreview() {
    val stat = PokemonStatUiModel(R.string.pokemon_stat_hp, "065", 65)
    MasterDetailsTheme(darkTheme = true) {
        PokemonStatRow(stat)
    }
}