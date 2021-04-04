package jet.pack.compose.masterdetails.ui.screens.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jet.pack.compose.masterdetails.data.IPokemonRepository
import jet.pack.compose.masterdetails.ui.model.PokemonDetailsUiModel
import jet.pack.compose.masterdetails.ui.model.mapper.PokemonDetailsUiMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class DetailsState {
    object Loading : DetailsState()
    data class Success(val pokemon: PokemonDetailsUiModel) : DetailsState()
    data class Error(val cause: Exception) : DetailsState()
}

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: IPokemonRepository,
    private val uiMapper: PokemonDetailsUiMapper
) : ViewModel() {

    private val _state = mutableStateOf<DetailsState>(DetailsState.Loading)
    val state: DetailsState by _state

    private lateinit var pokemonId: String
    // TODO Look into AssistedInject & navigation-compose
    fun init(id: String) {
        pokemonId = id
        if (state !is DetailsState.Success) {
            fetchPokemon(pokemonId = pokemonId)
        }
    }

    fun retry() {
        fetchPokemon(pokemonId = pokemonId)
    }

    private fun fetchPokemon(pokemonId: String) {
        _state.value = DetailsState.Loading
        viewModelScope.launch {
            try {
                val pokemon = repository.getPokemon(pokemonId = pokemonId)
                val pokemonUiItem = uiMapper.map(pokemon)
                _state.value = DetailsState.Success(pokemon = pokemonUiItem)
            } catch (e: Exception) {
                _state.value = DetailsState.Error(cause = e)
            }
        }
    }
}
