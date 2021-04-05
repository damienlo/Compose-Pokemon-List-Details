package jet.pack.compose.masterdetails.ui.screens.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import jet.pack.compose.masterdetails.data.IPokemonRepository
import jet.pack.compose.masterdetails.ui.model.mapper.PokemonPreviewUiMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PokemonListViewModelTest {

    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    private val repository: IPokemonRepository = mock()
    private val uiMapper: PokemonPreviewUiMapper = mock()

    @Test
    internal fun init_whenGetPokemonsReturnsException_thenStateIsError() = runBlockingTest {
//        whenever(repository.getPokemons())
//            .thenThrow(Exception("Boom!"))

        val vm = PokemonListViewModel(
            repository,
            uiMapper
        )

        assertTrue(vm.state is PokemonListState.Loading)
//        Warning: There are no current APIs to wait for writes to State<T> objects in tests.
//        https://developer.android.com/codelabs/jetpack-compose-state?index=..%2F..index#9
//        assertTrue(vm.state is PokemonListState.Error)
    }
}