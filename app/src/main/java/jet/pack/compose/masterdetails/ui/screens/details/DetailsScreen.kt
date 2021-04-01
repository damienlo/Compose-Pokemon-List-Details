package jet.pack.compose.masterdetails.ui.screens.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import jet.pack.compose.masterdetails.ui.model.DetailsUiItem
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@Composable
fun DetailsScreen(viewModel: DetailsViewModel) {
    val state: DetailsState by viewModel.state.observeAsState(DetailsState.Loading)
    StateDispatcher(uiState = state)
}

@Composable
private fun StateDispatcher(uiState: DetailsState) {
    when (uiState) {
        is DetailsState.Loading -> DetailsScreenLoading()
        is DetailsState.Success -> DetailsScreenSuccess(item = uiState.uiItem)
        is DetailsState.Error -> DetailsScreenError()
    }
}

@Composable
private fun DetailsScreenLoading() {
    Text("Loading")
}

@Composable
private fun DetailsScreenSuccess(item: DetailsUiItem) {
    Text("id: ${item.itemId}")
}

@Composable
private fun DetailsScreenError() {

}

// Previews

@Preview("Loading Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailsScreenLoadingLightPreview() {
    MasterDetailsTheme {
        DetailsScreenLoading()
    }
}

@Preview("Loading Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailsScreenLoadingDarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        DetailsScreenLoading()
    }
}

@Preview("Success Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailsScreenSuccessLightPreview() {
    val previewItem = DetailsUiItem(
        itemId = "itemId"
    )
    MasterDetailsTheme {
        DetailsScreenSuccess(item = previewItem)
    }
}

@Preview("Success Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailsScreenSuccessDarkPreview() {
    val previewItem = DetailsUiItem(
        itemId = "itemId"
    )
    MasterDetailsTheme {
        DetailsScreenSuccess(item = previewItem)
    }
}


@Preview("Error Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailsScreenErrorLightPreview() {
    MasterDetailsTheme {
        DetailsScreenError()
    }
}

@Preview("Error Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailsScreenErrorDarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        DetailsScreenError()
    }
}



