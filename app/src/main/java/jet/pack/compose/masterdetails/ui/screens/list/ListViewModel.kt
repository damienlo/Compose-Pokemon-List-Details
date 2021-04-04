package jet.pack.compose.masterdetails.ui.screens.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.getValue
import jet.pack.compose.masterdetails.data.remote.PokemonRemoteDataSource
import jet.pack.compose.masterdetails.data.repository.PokemonRepository
import jet.pack.compose.masterdetails.domain.GetPokemonPreviewsInteractor
import jet.pack.compose.masterdetails.domain.model.mapper.PokemonPreviewMapper
import jet.pack.compose.masterdetails.ui.model.PokemonPreviewUiModel
import jet.pack.compose.masterdetails.ui.model.mapper.PokemonPreviewUiMapper
import kotlinx.coroutines.launch
import java.lang.Exception


sealed class ListState {
    object Loading : ListState()
    data class Success(val pokemons: List<PokemonPreviewUiModel>) : ListState()
    data class Error(val cause: Exception) : ListState()
}

class ListViewModel(
    private val getPokemonPreviews: GetPokemonPreviewsInteractor,
    private val uiMapper: PokemonPreviewUiMapper
) : ViewModel() {

    private val _state = mutableStateOf<ListState>(ListState.Loading)
    val state: ListState by _state

    init {
        fetchPokemons()
    }

    fun retry() {
        fetchPokemons()
    }

    private fun fetchPokemons() {
        _state.value = ListState.Loading
        viewModelScope.launch {
            try {
                val pokemons = getPokemonPreviews()
                val pokemonUiItems = pokemons.map { uiMapper.map(it) }
                _state.value = ListState.Success(pokemons = pokemonUiItems)
            } catch (e: Exception) {
                _state.value = ListState.Error(cause = e)
            }
        }
    }
}

class ListViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ListViewModel::class.java) -> {
                val pokemonRepository = PokemonRepository(PokemonRemoteDataSource.pokemonService)
                ListViewModel(
                    getPokemonPreviews = GetPokemonPreviewsInteractor(
                        repository = pokemonRepository,
                        mapper = PokemonPreviewMapper()
                    ),
                    uiMapper = PokemonPreviewUiMapper()
                ) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel $modelClass")
        }
    }
}
