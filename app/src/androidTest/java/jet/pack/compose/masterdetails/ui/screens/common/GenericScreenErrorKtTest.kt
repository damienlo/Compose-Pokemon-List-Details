package jet.pack.compose.masterdetails.ui.screens.common

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import jet.pack.compose.masterdetails.MainActivity
import jet.pack.compose.masterdetails.R
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class GenericScreenErrorKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun genericErrorScreen_renderGenericErrorMessages() {
        val onClickCallback: () -> Unit = { }
        composeTestRule.setContent {
            MasterDetailsTheme {
                GenericScreenError(retryButtonClicked = onClickCallback)
            }
        }

        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.pokemon_generic_error_title))
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.pokemon_generic_error_subtitle))
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.pokemon_generic_error_button_retry))
            .assertIsDisplayed()
    }

    @Test
    fun genericErrorScreen_clickCallback() {
        var callbackCalled = false
        val onClickCallback: () -> Unit = { callbackCalled = true }
        composeTestRule.setContent {
            MasterDetailsTheme {
                GenericScreenError(retryButtonClicked = onClickCallback)
            }
        }

        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.pokemon_generic_error_button_retry))
            .performClick()

        Assert.assertTrue(callbackCalled)
    }
}