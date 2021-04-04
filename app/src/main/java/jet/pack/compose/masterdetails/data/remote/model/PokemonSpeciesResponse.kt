package jet.pack.compose.masterdetails.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonSpeciesResponse (
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "color")
    val color: PokemonNamedApiResourceResponse,
    @field:Json(name = "shape")
    val shape: PokemonNamedApiResourceResponse,
    @field:Json(name = "flavor_text_entries")
    val flavorTextEntries: List<PokemonFlavorText>
)
