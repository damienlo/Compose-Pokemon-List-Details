package jet.pack.compose.masterdetails.ui.screens.details

import androidx.annotation.FloatRange
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import jet.pack.compose.masterdetails.R
import jet.pack.compose.masterdetails.ui.components.PokemonImage
import jet.pack.compose.masterdetails.ui.components.PokemonMoveRow
import jet.pack.compose.masterdetails.ui.components.PokemonStatRow
import jet.pack.compose.masterdetails.ui.components.PokemonTypeBullet
import jet.pack.compose.masterdetails.ui.model.PokemonDetailsUiModel
import jet.pack.compose.masterdetails.ui.model.PokemonMoveUiModel
import jet.pack.compose.masterdetails.ui.model.PokemonStatUiModel
import jet.pack.compose.masterdetails.ui.model.PokemonTypeUiModel
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@Composable
@OptIn(ExperimentalMaterialApi::class)
internal fun DetailsScreenSuccess(pokemon: PokemonDetailsUiModel) {
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed)
    LaunchedEffect(scaffoldState) {
        scaffoldState.reveal()
    }
    BackdropScaffold(
        scaffoldState = scaffoldState,
        appBar = {
            DetailsScreenTopBar(pokemon = pokemon)
        },
        backLayerContent = {
            DetailsScreenBackGround(pokemon = pokemon)
        },
        frontLayerScrimColor = Color.Transparent,
        frontLayerContent = {
            DetailsScreenBody(pokemon = pokemon)
        }
    )
}

@Composable
fun DetailsScreenTopBar(pokemon: PokemonDetailsUiModel) {
    TopAppBar(
        title = {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* */ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "back arrow")
            }
        },
        elevation = 0.dp,
        backgroundColor = Color.Transparent
    )
}

@Composable
private fun DetailsScreenBackGround(pokemon: PokemonDetailsUiModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(percentScreenHeight(.33f))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "# %03d".format(pokemon.id.toInt()),
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            val height = "%.1f".format(pokemon.height / 10f)
            Text(
                text = stringResource(R.string.pokemon_details_height, height),
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            val weight = "%.1f".format(pokemon.weight / 10f)
            Text(
                text = stringResource(R.string.pokemon_details_weight, weight),
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onPrimary
            )
        }
        PokemonImage(
            uri = pokemon.imageUrl,
            modifier = Modifier
                .size(196.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun DetailsScreenBody(pokemon: PokemonDetailsUiModel) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // Types
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            pokemon.types.forEachIndexed { index, type ->
                if (index > 0) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
                PokemonTypeBullet(type = type)
            }
        }
        // Description
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = pokemon.description,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface
        )
        // Stats
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.pokemon_details_stats_title),
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            pokemon.stats.forEach { stat -> PokemonStatRow(stat) }
        }
        // Moves
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.pokemon_details_moves_title),
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column {
            pokemon.moves.forEachIndexed { index, move ->
                PokemonMoveRow(move)
                if (index < pokemon.moves.lastIndex) {
                    Divider(thickness = 1.dp)
                }
            }
        }
    }
}

@Composable
private fun percentScreenHeight(@FloatRange(from = 0.0, to = 1.0) percent: Float): Dp {
    val displayMetrics = LocalContext.current.resources.displayMetrics
    val heightDp = with(LocalDensity.current) { displayMetrics.heightPixels.toDp() }
    return (heightDp.value * percent).dp
}

@Preview("Details Success Screen Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailsScreenSuccessLightPreview() {
    MasterDetailsTheme {
        val pokemon = PokemonDetailsUiModel(
            id = "1",
            name = "Bulbasaur",
            description = "Bulbasaur is a ...",
            imageUrl = "url",
            height = 7,
            weight = 69,
            types = listOf(PokemonTypeUiModel.GRASS),
            stats = listOf(PokemonStatUiModel(R.string.pokemon_stat_hp, "065", 65)),
            moves = listOf(
                PokemonMoveUiModel(
                    "Whip",
                    "whip",
                    "40",
                    "60",
                    PokemonTypeUiModel.GRASS
                )
            )
        )
        DetailsScreenSuccess(pokemon)
    }
}

@Preview("Details Success Screen Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailsScreenSuccessDarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        MasterDetailsTheme {
            val pokemon = PokemonDetailsUiModel(
                id = "1",
                name = "Bulbasaur",
                description = "Bulbasaur is a ...",
                imageUrl = "url",
                height = 7,
                weight = 69,
                types = listOf(PokemonTypeUiModel.GRASS),
                stats = listOf(PokemonStatUiModel(R.string.pokemon_stat_hp, "065", 65)),
                moves = listOf(
                    PokemonMoveUiModel(
                        "Whip",
                        "whip",
                        "40",
                        "60",
                        PokemonTypeUiModel.GRASS
                    )
                )
            )
            DetailsScreenSuccess(pokemon)
        }
    }
}


