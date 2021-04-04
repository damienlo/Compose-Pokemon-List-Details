package jet.pack.compose.masterdetails.ui.screens.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jet.pack.compose.masterdetails.ui.components.PokemonImage
import jet.pack.compose.masterdetails.ui.model.PokemonPreviewUiModel
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@Composable
internal fun ListSuccessScreen(
    pokemons: List<PokemonPreviewUiModel>,
    showDetails: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pokemons) { item ->
            PokemonItem(item, showDetails)
        }
    }
}

@Composable
private fun PokemonItem(
    pokemon: PokemonPreviewUiModel,
    showDetails: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .clickable { showDetails(pokemon.id) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            PokemonImage(
                uri = pokemon.imageUrl,
                modifier = Modifier.size(96.dp),
                contentDescription = pokemon.name
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = pokemon.name,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "# %03d".format(pokemon.id.toInt()),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}


@Preview("Success Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun ListScreenSuccessLightPreview() {
    val previewItem = PokemonPreviewUiModel(
        id = "1",
        name = "Bulbasaur",
        imageUrl = "null"
    )
    MasterDetailsTheme {
        ListSuccessScreen(pokemons = listOf(previewItem), showDetails = { /* */ })
    }
}

@Preview("Success Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun ListScreenSuccessDarkPreview() {
    val previewItem = PokemonPreviewUiModel(
        id = "1",
        name = "Bulbasaur",
        imageUrl = "null"
    )
    MasterDetailsTheme {
        ListSuccessScreen(pokemons = listOf(previewItem), showDetails = { /* */ })
    }
}
