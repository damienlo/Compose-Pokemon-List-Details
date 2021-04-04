package jet.pack.compose.masterdetails.ui.screens.list

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import jet.pack.compose.masterdetails.ui.screens.common.GenericScreenError
import jet.pack.compose.masterdetails.ui.screens.common.GenericScreenLoading

@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel,
    showDetails: (String) -> Unit
) {
    val screenState = viewModel.state
    Crossfade(targetState = screenState) {
        when (screenState) {
            is PokemonListState.Loading -> GenericScreenLoading()
            is PokemonListState.Success -> ListSuccessScreen(
                pokemons = screenState.pokemons,
                showDetails = showDetails
            )
            is PokemonListState.Error -> GenericScreenError(retryButtonClicked = { viewModel.retry() })
        }
    }
}
