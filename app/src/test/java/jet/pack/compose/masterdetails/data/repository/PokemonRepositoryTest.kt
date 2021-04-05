package jet.pack.compose.masterdetails.data.repository

import jet.pack.compose.masterdetails.data.IPokemonRepository
import jet.pack.compose.masterdetails.data.model.Pokemon
import jet.pack.compose.masterdetails.data.model.PokemonPreview
import jet.pack.compose.masterdetails.data.remote.PokemonService
import jet.pack.compose.masterdetails.data.remote.model.PokemonDetailsMoveResponse
import jet.pack.compose.masterdetails.data.remote.model.PokemonDetailsMoveVersion
import jet.pack.compose.masterdetails.data.remote.model.PokemonDetailsResponse
import jet.pack.compose.masterdetails.data.remote.model.PokemonMoveResponse
import jet.pack.compose.masterdetails.data.remote.model.PokemonNamedApiResourceResponse
import jet.pack.compose.masterdetails.data.remote.model.PokemonPaginatedResponse
import jet.pack.compose.masterdetails.data.remote.model.PokemonSpeciesResponse
import jet.pack.compose.masterdetails.data.remote.model.mapper.PokemonMapper
import jet.pack.compose.masterdetails.data.remote.model.mapper.PokemonPreviewMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verifyZeroInteractions
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PokemonRepositoryTest {

    private val service: PokemonService = mock()
    private val previewMapper: PokemonPreviewMapper = mock()
    private val pokemonMapper: PokemonMapper = mock()
    private val dispatcher: CoroutineDispatcher = Dispatchers.Unconfined

    private val repository: IPokemonRepository = PokemonRepository(
        service,
        previewMapper,
        pokemonMapper,
        dispatcher
    )

    @Test(expected = Exception::class)
    fun getPokemons_whenServiceThrowException() = runBlockingTest {
        whenever(service.getPokemons(anyInt(), anyInt()))
            .thenThrow(Exception("Boom!"))

        repository.getPokemons()

        verifyZeroInteractions(previewMapper)
    }

    @Test
    fun getPokemons_whenServiceReturnsPokemonPaginatedResponse_thenReturnPokemonPreviews() =
        runBlockingTest {
            val mockPokemonNamedApiResourceResponse = mock<PokemonNamedApiResourceResponse>()
            val response = mock<PokemonPaginatedResponse> {
                on { results } doReturn listOf(mockPokemonNamedApiResourceResponse)
            }
            val mockPokemonPreview = mock<PokemonPreview>()
            whenever(service.getPokemons(anyInt(), anyInt()))
                .thenReturn(response)
            whenever(previewMapper.map(mockPokemonNamedApiResourceResponse))
                .doReturn(mockPokemonPreview)

            val result = repository.getPokemons()

            assertEquals(listOf(mockPokemonPreview), result)
        }

    @Test(expected = Exception::class)
    fun getPokemon_whenServiceThrowException() = runBlockingTest {
        whenever(service.getPokemon("pokemonId"))
            .thenThrow(Exception("Boom!"))

        repository.getPokemon("pokemonId")

        verifyZeroInteractions(pokemonMapper)
    }

    @Test
    fun getPokemon_whenServiceReturnPokemonDetailsResponse_thenReturnPokemon() = runBlockingTest {
        val mockPokemonDetailsResponse = createMockPokemonDetailsResponse()
        val mockSpecies = mock<PokemonSpeciesResponse>()
        val mockMoves = mock<PokemonMoveResponse>()
        val mockPokemon = mock<Pokemon>()
        whenever(service.getPokemon("pokemonId"))
            .thenReturn(mockPokemonDetailsResponse)
        whenever(service.getPokemonSpecies("1"))
            .doReturn(mockSpecies)
        whenever(service.getPokemonMove("2"))
            .doReturn(mockMoves)
        whenever(pokemonMapper.map(mockPokemonDetailsResponse, mockSpecies, listOf(mockMoves)))
            .doReturn(mockPokemon)

        val result = repository.getPokemon("pokemonId")

        assertEquals(mockPokemon, result)
    }

    private fun createMockPokemonDetailsResponse(): PokemonDetailsResponse {
        val mockSpecies = mock<PokemonNamedApiResourceResponse> {
            on { url } doReturn "/1/"
        }
        val mockMove = mock<PokemonNamedApiResourceResponse> {
            on { url } doReturn "/2/"
        }
        val mockPokemonDetailsMoveResponse = mock<PokemonDetailsMoveVersion> {
            on { learnedAt } doReturn 1
        }
        val pokemonDetailsMoveResponse = mock<PokemonDetailsMoveResponse> {
            on { move } doReturn mockMove
            on { versionGroupDetails } doReturn listOf(mockPokemonDetailsMoveResponse)
        }
        return mock {
            on { species } doReturn mockSpecies
            on { moves } doReturn listOf(pokemonDetailsMoveResponse)
        }
    }

}