package jet.pack.compose.masterdetails.ui.screens.details

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import jet.pack.compose.masterdetails.ui.screens.common.GenericScreenError
import jet.pack.compose.masterdetails.ui.screens.common.GenericScreenLoading

@Composable
fun DetailsScreen(viewModel: DetailsViewModel) {
    val screenState = viewModel.state
    Crossfade(targetState = screenState) {
        when (screenState) {
            is DetailsState.Loading -> GenericScreenLoading()
            is DetailsState.Success -> DetailsScreenSuccess(pokemon = screenState.pokemon)
            is DetailsState.Error -> GenericScreenError(retryButtonClicked = { viewModel.retry() })
        }
    }
}