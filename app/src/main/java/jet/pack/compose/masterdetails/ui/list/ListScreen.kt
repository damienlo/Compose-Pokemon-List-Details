package jet.pack.compose.masterdetails.ui.list

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@Composable
fun ListScreen(showDetails: (String) -> Unit) {
    Button(
        onClick = { showDetails("#010101") },
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            "Go to details #010101",
            style = MaterialTheme.typography.button
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MasterDetailsTheme {
        ListScreen(showDetails = { /* nothing to do here */ })
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        ListScreen(showDetails = { /* nothing to do here */ })
    }
}
