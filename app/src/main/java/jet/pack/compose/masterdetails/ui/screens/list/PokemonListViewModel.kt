package jet.pack.compose.masterdetails.ui.screens.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jet.pack.compose.masterdetails.data.IPokemonRepository
import jet.pack.compose.masterdetails.ui.model.PokemonPreviewUiModel
import jet.pack.compose.masterdetails.ui.model.mapper.PokemonPreviewUiMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class PokemonListState {
    object Loading : PokemonListState()
    data class Success(val pokemons: List<PokemonPreviewUiModel>) : PokemonListState()
    data class Error(val cause: Exception) : PokemonListState()
}

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: IPokemonRepository,
    private val uiMapper: PokemonPreviewUiMapper
) : ViewModel() {

    private val _state = mutableStateOf<PokemonListState>(PokemonListState.Loading)
    val state: PokemonListState by _state

    init {
        fetchPokemons()
    }

    fun retry() {
        fetchPokemons()
    }

    private fun fetchPokemons() {
        _state.value = PokemonListState.Loading
        viewModelScope.launch {
            try {
                val pokemons = repository.getPokemons()
                val pokemonUiItems = pokemons.map { uiMapper.map(it) }
                _state.value = PokemonListState.Success(pokemons = pokemonUiItems)
            } catch (e: Exception) {
                _state.value = PokemonListState.Error(cause = e)
            }
        }
    }
}