package jet.pack.compose.masterdetails.ui.screens.list

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import jet.pack.compose.masterdetails.MainActivity
import jet.pack.compose.masterdetails.ui.model.PokemonPreviewUiModel
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


class ListSuccessScreenKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val previewItem = PokemonPreviewUiModel(
        id = "1",
        name = "Bulbasaur",
        imageUrl = "null"
    )

    @Test
    fun listSuccessScreen_renderNameAndId() {
        val showDetailsCallback: (String) -> Unit = { }
        composeTestRule.setContent {
            MasterDetailsTheme {
                ListSuccessScreen(
                    pokemons = listOf(previewItem),
                    showDetails = showDetailsCallback
                )
            }
        }
        composeTestRule
            .onNodeWithText(text = "Bulbasaur", useUnmergedTree = true)
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText(text = "# 001", useUnmergedTree = true)
            .assertIsDisplayed()
    }

    @Test
    fun listSuccessScreen_clickCallbackWithPokemonId() {
        var selectedPokemonId: String? = null
        val showDetailsCallback: (String) -> Unit = { id -> selectedPokemonId = id }
        composeTestRule.setContent {
            MasterDetailsTheme {
                ListSuccessScreen(
                    pokemons = listOf(previewItem),
                    showDetails = showDetailsCallback
                )
            }
        }

        composeTestRule
            .onNodeWithText(text = "Bulbasaur", useUnmergedTree = true)
            .performClick()

        assertEquals("1", selectedPokemonId)
    }
}