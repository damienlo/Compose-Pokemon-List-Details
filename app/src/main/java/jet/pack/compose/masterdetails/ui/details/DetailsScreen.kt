package jet.pack.compose.masterdetails.ui.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@Composable
fun DetailsScreen(itemId: String) {
    Text("Item : $itemId")
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MasterDetailsTheme {
        DetailsScreen(itemId = "itemId")
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        DetailsScreen(itemId = "itemId")
    }
}


