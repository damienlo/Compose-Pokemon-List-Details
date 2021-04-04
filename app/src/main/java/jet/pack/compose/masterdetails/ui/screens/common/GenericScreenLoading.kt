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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jet.pack.compose.masterdetails.R
import jet.pack.compose.masterdetails.ui.components.RotatingPokeball
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@Composable
internal fun GenericScreenLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RotatingPokeball(modifier = Modifier.size(96.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.pokemon_generic_loading),
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}


@Preview("Loading Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun GenericScreenLoadingLightPreview() {
    MasterDetailsTheme {
        GenericScreenLoading()
    }
}

@Preview("Loading Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun GenericScreenLoadingDarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        GenericScreenLoading()
    }
}
