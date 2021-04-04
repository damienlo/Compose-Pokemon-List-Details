package jet.pack.compose.masterdetails.ui.screens.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jet.pack.compose.masterdetails.domain.GetPokemonPreviewsInteractor
import jet.pack.compose.masterdetails.ui.model.PokemonPreviewUiModel
import jet.pack.compose.masterdetails.ui.model.mapper.PokemonPreviewUiMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class ListState {
    object Loading : ListState()
    data class Success(val pokemons: List<PokemonPreviewUiModel>) : ListState()
    data class Error(val cause: Exception) : ListState()
}

@HiltViewModel
class ListViewModel @Inject constructor(
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