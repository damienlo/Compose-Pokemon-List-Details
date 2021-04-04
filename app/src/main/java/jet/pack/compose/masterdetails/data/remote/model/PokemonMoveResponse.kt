package jet.pack.compose.masterdetails.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonMoveResponse(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "accuracy")
    val accuracy: Int?,
    @field:Json(name = "power")
    val power: Int?,
    @field:Json(name = "names")
    val names: List<PokemonMoveNameResponse>,
    @field:Json(name = "flavor_text_entries")
    val flavorTextEntries: List<PokemonFlavorText>,
    @field:Json(name = "type")
    val type: PokemonNamedApiResourceResponse
)

@JsonClass(generateAdapter = true)
data class PokemonMoveNameResponse(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "language")
    val language: PokemonNamedApiResourceResponse
)