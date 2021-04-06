package jet.pack.compose.masterdetails.ui.screens.common

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import jet.pack.compose.masterdetails.MainActivity
import jet.pack.compose.masterdetails.R
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme
import org.junit.Rule
import org.junit.Test

class GenericScreenLoadingKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun genericLoadingScreen_renderGenericLoadingMessages() {
        composeTestRule.setContent {
            MasterDetailsTheme {
                GenericScreenLoading()
            }
        }

        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.pokemon_generic_loading))
            .assertIsDisplayed()
    }
}