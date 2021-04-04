package jet.pack.compose.masterdetails.data.remote.model.mapper

import jet.pack.compose.masterdetails.data.remote.model.PokemonDetailsResponse
import jet.pack.compose.masterdetails.data.remote.model.PokemonDetailsStatResponse
import jet.pack.compose.masterdetails.data.remote.model.PokemonFlavorText
import jet.pack.compose.masterdetails.data.remote.model.PokemonMoveResponse
import jet.pack.compose.masterdetails.data.remote.model.PokemonSpeciesResponse
import jet.pack.compose.masterdetails.data.model.Move
import jet.pack.compose.masterdetails.data.model.Pokemon
import jet.pack.compose.masterdetails.data.model.PokemonType
import jet.pack.compose.masterdetails.data.model.Stat
import javax.inject.Inject

class PokemonMapper @Inject constructor() {

    fun map(
        pokemonDataModel: PokemonDetailsResponse,
        species: PokemonSpeciesResponse,
        moves: List<PokemonMoveResponse>
    ): Pokemon = Pokemon(
        id = pokemonDataModel.id.toString(),
        name = pokemonDataModel.name,
        description = species.flavorTextEntries.getDescription(),
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemonDataModel.id.toString()}.png",
        mainColor = getMainColor(species),
        height = pokemonDataModel.height,
        weight = pokemonDataModel.weight,
        moves = moves.map { it.toMove() },
        stats = pokemonDataModel.stats.map { it.toStat() },
        types = pokemonDataModel.types.map { it.type.name.toPokemonType() }
    )

    private fun String.toPokemonType(): PokemonType =
        PokemonType.values().find { it.strValue == this } ?: PokemonType.UNKNOWN

    private fun PokemonMoveResponse.toMove(): Move = Move(
        name = this.name,
        description = this.flavorTextEntries.getDescription(),
        accuracy = this.accuracy,
        power = this.power,
        type = this.type.name.toPokemonType()
    )

    private fun PokemonDetailsStatResponse.toStat(): Stat = Stat(
        name = this.stat.name,
        value = this.baseStat
    )

    private fun List<PokemonFlavorText>.getDescription(): String =
        find { it.language.name == "en" }!!.flavorText

    private fun getMainColor(species: PokemonSpeciesResponse): String =
        species.color.name
}