package jet.pack.compose.masterdetails.ui.screens.details

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import jet.pack.compose.masterdetails.MainActivity
import jet.pack.compose.masterdetails.R
import jet.pack.compose.masterdetails.ui.model.PokemonDetailsUiModel
import jet.pack.compose.masterdetails.ui.model.PokemonMoveUiModel
import jet.pack.compose.masterdetails.ui.model.PokemonStatUiModel
import jet.pack.compose.masterdetails.ui.model.PokemonTypeUiModel
import jet.pack.compose.masterdetails.ui.theme.MasterDetailsTheme
import org.junit.Rule
import org.junit.Test

class DetailsSuccessScreenKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val pokemon = PokemonDetailsUiModel(
        id = "1",
        name = "Bulbasaur",
        description = "Bulbasaur is a ...",
        imageUrl = "url",
        height = 7,
        weight = 69,
        types = listOf(PokemonTypeUiModel.GRASS),
        stats = listOf(PokemonStatUiModel(R.string.pokemon_stat_hp, "065", 65)),
        moves = listOf(
            PokemonMoveUiModel(
                "Whip",
                "whip",
                "40",
                "60",
                PokemonTypeUiModel.GRASS
            )
        )
    )

    @Test
    fun detailsSuccessScreen_renderPokemonDetails() {
        composeTestRule.setContent {
            MasterDetailsTheme {
                DetailsScreenSuccess(pokemon = pokemon)
            }
        }
        composeTestRule
            .onNodeWithText(text = "Bulbasaur")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText(text = "# 001")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText(
                text = composeTestRule.activity.resources.getString(
                    R.string.pokemon_details_height,
                    "0.7"
                )
            )
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText(
                text = composeTestRule.activity.resources.getString(
                    R.string.pokemon_details_weight,
                    "6.9"
                )
            )
            .assertIsDisplayed()
    }

}