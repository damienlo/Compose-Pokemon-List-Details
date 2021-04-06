package jet.pack.compose.masterdetails.ui.components

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import jet.pack.compose.masterdetails.MainActivity
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class PokemonButtonKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun pokemonButtonTest_renderUppercaseText() {
        val onClickCallback: () -> Unit = { }
        composeTestRule.setContent {
            MasterDetailsTheme {
                PokemonButton("Button Text", onClick = onClickCallback)
            }
        }

        composeTestRule
            .onNodeWithText("BUTTON TEXT")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun pokemonButtonTest_clickCallback() {
        var callbackCalled = false
        val onClickCallback: () -> Unit = { callbackCalled = true }
        composeTestRule.setContent {
            MasterDetailsTheme {
                PokemonButton("Button Text", onClick = onClickCallback)
            }
        }

        composeTestRule
            .onNodeWithText("BUTTON TEXT")
            .performClick()

        assertTrue(callbackCalled)
    }


}