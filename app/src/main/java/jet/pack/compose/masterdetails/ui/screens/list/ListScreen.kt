package jet.pack.compose.masterdetails.ui.screens.list

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import jet.pack.compose.masterdetails.ui.model.ListPreviewUiItem
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@Composable
fun ListScreen(
    viewModel: ListViewModel,
    showDetails: (String) -> Unit
) {
    val state: ListState by viewModel.state.observeAsState(ListState.Loading)
    StateDispatcher(uiState = state, showDetails = showDetails)
}

@Composable
private fun StateDispatcher(
    uiState: ListState,
    showDetails: (String) -> Unit
) {
    when (uiState) {
        is ListState.Loading -> ListScreenLoading()
        is ListState.Success -> ListScreenSuccess(
            items = uiState.uiItems,
            showDetails = showDetails
        )
        is ListState.Error -> ListScreenError()
    }
}

@Composable
private fun ListScreenLoading() {
    Text("Loading")
}

@Composable
private fun ListScreenSuccess(
    items: List<ListPreviewUiItem>,
    showDetails: (String) -> Unit
) {
    Button(
        onClick = { showDetails(items.first().itemId) },
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            "Go to details #010101",
            style = MaterialTheme.typography.button
        )
    }
}

@Composable
private fun ListScreenError() {

}

// Previews

@Preview("Loading Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun ListScreenLoadingLightPreview() {
    MasterDetailsTheme {
        ListScreenLoading()
    }
}

@Preview("Loading Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun ListScreenLoadingDarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        ListScreenLoading()
    }
}

@Preview("Success Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun ListScreenSuccessLightPreview() {
    val previewItem = ListPreviewUiItem(
        itemId = "itemId"
    )
    MasterDetailsTheme {
        ListScreenSuccess(items = listOf(previewItem), showDetails = { /* */ })
    }
}

@Preview("Success Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun ListScreenSuccessDarkPreview() {
    val previewItem = ListPreviewUiItem(
        itemId = "itemId"
    )
    MasterDetailsTheme {
        ListScreenSuccess(items = listOf(previewItem), showDetails = { /* */ })
    }
}


@Preview("Error Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun ListScreenErrorLightPreview() {
    MasterDetailsTheme {
        ListScreenError()
    }
}

@Preview("Error Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun ListScreenErrorDarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        ListScreenError()
    }
}




