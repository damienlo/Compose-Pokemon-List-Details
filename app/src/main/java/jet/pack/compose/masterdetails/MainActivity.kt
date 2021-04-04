package jet.pack.compose.masterdetails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import jet.pack.compose.masterdetails.ui.screens.home.HomeScreen
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MasterDetailsTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    ProvideWindowInsets {
        Surface(color = MaterialTheme.colors.background) {
            HomeScreen()
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MasterDetailsTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MasterDetailsTheme(darkTheme = true) {
        MyApp()
    }
}
