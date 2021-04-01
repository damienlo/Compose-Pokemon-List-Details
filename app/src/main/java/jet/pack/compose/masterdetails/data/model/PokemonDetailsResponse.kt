package jet.pack.compose.masterdetails.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDetailsResponse(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "height")
    val height: Int,
    @field:Json(name = "weight")
    val weight: Int,
    @field:Json(name = "species")
    val species: PokemonNamedApiResourceResponse,
    @field:Json(name = "moves")
    val moves: List<PokemonDetailsMoveResponse>,
    @field:Json(name = "stats")
    val stats: List<PokemonDetailsStatResponse>,
    @field:Json(name = "types")
    val types: List<PokemonDetailsTypeResponse>,
)

@JsonClass(generateAdapter = true)
data class PokemonDetailsMoveResponse(
    @field:Json(name = "move")
    val move: PokemonNamedApiResourceResponse,
    @field:Json(name = "version_group_details")
    val versionGroupDetails: List<PokemonDetailsMoveVersion>
)

@JsonClass(generateAdapter = true)
data class PokemonDetailsMoveVersion(
    @field:Json(name = "level_learned_at")
    val learnedAt: Int
)

@JsonClass(generateAdapter = true)
data class PokemonDetailsStatResponse(
    @field:Json(name = "stat")
    val stat: PokemonNamedApiResourceResponse,
    @field:Json(name = "effort")
    val effort: Int,
    @field:Json(name = "base_stat")
    val baseStat: Int
)

@JsonClass(generateAdapter = true)
data class PokemonDetailsTypeResponse(
    @field:Json(name = "slot")
    val slot: Int,
    @field:Json(name = "type")
    val type: PokemonNamedApiResourceResponse
)
