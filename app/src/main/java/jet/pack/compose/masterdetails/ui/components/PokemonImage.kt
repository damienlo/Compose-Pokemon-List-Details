package jet.pack.compose.masterdetails.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage


@Composable
fun PokemonImage(
    uri: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    CoilImage(
        data = uri,
        modifier = modifier,
        contentScale = ContentScale.Crop,
        contentDescription = contentDescription,
        loading = { PokemonImageLoadingState() },
        error = { PokemonImageErrorState() }
    )
}

@Composable
private fun PokemonImageLoadingState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        RotatingPokeball(modifier = Modifier.size(48.dp))
    }
}

@Composable
private fun PokemonImageErrorState() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.error),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Error!",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onError,
            modifier = Modifier.padding(8.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}