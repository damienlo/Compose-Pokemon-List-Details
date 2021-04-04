package jet.pack.compose.masterdetails.ui.screens.list

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import jet.pack.compose.masterdetails.ui.screens.common.GenericScreenError
import jet.pack.compose.masterdetails.ui.screens.common.GenericScreenLoading

@Composable
fun ListScreen(
    viewModel: ListViewModel,
    showDetails: (String) -> Unit
) {
    val screenState = viewModel.state
    Crossfade(targetState = screenState) {
        when (screenState) {
            is ListState.Loading -> GenericScreenLoading()
            is ListState.Success -> ListSuccessScreen(
                pokemons = screenState.pokemons,
                showDetails = showDetails
            )
            is ListState.Error -> GenericScreenError(retryButtonClicked = { viewModel.retry() })
        }
    }
}
