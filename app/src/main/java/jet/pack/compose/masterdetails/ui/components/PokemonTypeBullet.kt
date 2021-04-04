package jet.pack.compose.masterdetails.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jet.pack.compose.masterdetails.ui.model.PokemonTypeUiModel
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@Composable
fun PokemonTypeBullet(type: PokemonTypeUiModel, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(percent = 50),
        elevation = 0.dp,
        backgroundColor = if (isSystemInDarkTheme()) type.darkColor else type.lightColor,
        modifier = modifier
    ) {
        Text(
            text = stringResource(type.nameResId),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Preview("Bullet Light Theme")
@Composable
fun PokemonTypeBulletLightPreview() {
    MasterDetailsTheme {
        PokemonTypeBullet(PokemonTypeUiModel.GRASS)
    }
}

@Preview("Bullet Dark Theme")
@Composable
fun PokemonTypeBulletErrorDarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        PokemonTypeBullet(PokemonTypeUiModel.GRASS)
    }
}


