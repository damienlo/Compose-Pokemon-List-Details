package jet.pack.compose.masterdetails.ui.screens.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import jet.pack.compose.masterdetails.data.remote.PokemonRemoteDataSource
import jet.pack.compose.masterdetails.data.repository.PokemonRepository
import jet.pack.compose.masterdetails.domain.GetPokemonDetailsInteractor
import jet.pack.compose.masterdetails.domain.model.mapper.PokemonMapper
import jet.pack.compose.masterdetails.ui.model.PokemonDetailsUiModel
import jet.pack.compose.masterdetails.ui.model.mapper.PokemonDetailsUiMapper
import jet.pack.compose.masterdetails.ui.model.mapper.PokemonMoveUiMapper
import jet.pack.compose.masterdetails.ui.model.mapper.PokemonStatUiMapper
import jet.pack.compose.masterdetails.ui.model.mapper.PokemonTypeUiMapper
import kotlinx.coroutines.launch
import java.lang.Exception

sealed class DetailsState {
    object Loading : DetailsState()
    data class Success(val pokemon: PokemonDetailsUiModel) : DetailsState()
    data class Error(val cause: Exception) : DetailsState()
}

class DetailsViewModel(
    private val pokemonId: String,
    private val getPokemonDetails: GetPokemonDetailsInteractor,
    private val uiMapper: PokemonDetailsUiMapper
) : ViewModel() {

    private val _state = mutableStateOf<DetailsState>(DetailsState.Loading)
    val state: DetailsState by _state

    init {
        fetchPokemon(pokemonId = pokemonId)
    }

    fun retry() {
        fetchPokemon(pokemonId = pokemonId)
    }

    private fun fetchPokemon(pokemonId: String) {
        _state.value = DetailsState.Loading
        viewModelScope.launch {
            try {
            val pokemon = getPokemonDetails(pokemonId = pokemonId)
            val pokemonUiItem = uiMapper.map(pokemon)
            _state.value = DetailsState.Success(pokemon = pokemonUiItem)
            } catch (e: Exception) {
                _state.value = DetailsState.Error(cause = e)
            }
        }
    }
}

class DetailsViewModelFactory(
    private val itemId: String
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val pokemonRepository = PokemonRepository(PokemonRemoteDataSource.pokemonService)
        return when {
            modelClass.isAssignableFrom(DetailsViewModel::class.java) -> {
                DetailsViewModel(
                    pokemonId = itemId,
                    getPokemonDetails = GetPokemonDetailsInteractor(
                        repository = pokemonRepository,
                        mapper = PokemonMapper()
                    ),
                    uiMapper = PokemonDetailsUiMapper(
                        typeUiMapper = PokemonTypeUiMapper(),
                        statUiMapper = PokemonStatUiMapper(),
                        moveUiMapper = PokemonMoveUiMapper(
                            typeUiMapper = PokemonTypeUiMapper()
                        )
                    )
                ) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel $modelClass")
        }
    }
}
