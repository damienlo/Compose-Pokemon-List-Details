package jet.pack.compose.masterdetails.data.remote.model.mapper

internal object PokemonIdExtractorUtils {

    private val pokemonIdPattern = "/\\d+/".toRegex()

    fun String.extractId(): String {
        val idChunk = pokemonIdPattern.find(this)!!.value
        return idChunk.drop(1).dropLast(1)
    }
}