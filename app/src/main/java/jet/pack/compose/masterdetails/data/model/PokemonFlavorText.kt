package jet.pack.compose.masterdetails.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonFlavorText(
    @field:Json(name = "flavor_text")
    val flavorText: String,
    @field:Json(name = "language")
    val language: PokemonNamedApiResourceResponse,
)