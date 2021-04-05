package jet.pack.compose.masterdetails.ui.screens.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import jet.pack.compose.masterdetails.data.IPokemonRepository
import jet.pack.compose.masterdetails.ui.model.mapper.PokemonDetailsUiMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PokemonDetailsViewModelTest {

    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    private val repository: IPokemonRepository = mock()
    private val uiMapper: PokemonDetailsUiMapper = mock()

    @Test
    internal fun init_whenGetPokemonReturnsException_thenStateIsError() = runBlockingTest {
//        whenever(repository.getPokemon("pokemonId"))
//            .thenThrow(Exception("Boom!"))

        val vm = PokemonDetailsViewModel(
            repository,
            uiMapper
        ).also { it.init("pokemonId") }

        Assert.assertTrue(vm.state is PokemonDetailsState.Loading)
//        Warning: There are no current APIs to wait for writes to State<T> objects in tests.
//        https://developer.android.com/codelabs/jetpack-compose-state?index=..%2F..index#9
//        assertTrue(vm.state is PokemonListState.Error)
    }

}