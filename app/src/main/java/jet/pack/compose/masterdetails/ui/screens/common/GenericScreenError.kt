package jet.pack.compose.masterdetails.ui.screens.common


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jet.pack.compose.masterdetails.R
import jet.pack.compose.masterdetails.ui.components.Pokeball
import jet.pack.compose.masterdetails.ui.components.PokemonButton
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@Composable
internal fun GenericScreenError(retryButtonClicked: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Pokeball(
                modifier = Modifier
                    .size(96.dp)
                    .rotate(45f)
                    .alpha(.8f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.pokemon_generic_error_title),
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.pokemon_generic_error_subtitle),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(16.dp))
            PokemonButton(
                text = stringResource(R.string.pokemon_generic_error_button_retry),
                onClick = retryButtonClicked
            )
        }
    }
}


@Preview("Error Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun GenericScreenErrorLightPreview() {
    MasterDetailsTheme {
        GenericScreenError(retryButtonClicked = { /* */ })
    }
}

@Preview("Error Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun GenericScreenErrorDarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        GenericScreenError(retryButtonClicked = { /* */ })
    }
}
