package jet.pack.compose.masterdetails.ui.screens.details

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import jet.pack.compose.masterdetails.ui.screens.common.GenericScreenError
import jet.pack.compose.masterdetails.ui.screens.common.GenericScreenLoading

@Composable
fun PokemonDetailsScreen(viewModel: PokemonDetailsViewModel) {
    val screenState = viewModel.state
    Crossfade(targetState = screenState) {
        when (screenState) {
            is PokemonDetailsState.Loading -> GenericScreenLoading()
            is PokemonDetailsState.Success -> DetailsScreenSuccess(pokemon = screenState.pokemon)
            is PokemonDetailsState.Error -> GenericScreenError(retryButtonClicked = { viewModel.retry() })
        }
    }
}