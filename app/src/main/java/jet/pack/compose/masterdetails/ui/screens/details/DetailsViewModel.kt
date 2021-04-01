package jet.pack.compose.masterdetails.ui.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import jet.pack.compose.masterdetails.ui.model.DetailsUiItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

sealed class DetailsState {
    object Loading : DetailsState()
    data class Success(val uiItem: DetailsUiItem) : DetailsState()
    data class Error(val cause: Exception) : DetailsState()
}

class DetailsViewModel(itemId: String) : ViewModel() {

    private val _state = MutableLiveData<DetailsState>()
    val state: LiveData<DetailsState> = _state

    init {
        _state.value = DetailsState.Loading
        viewModelScope.launch {
            delay(750L)
            _state.value = DetailsState.Success(
                DetailsUiItem(
                    itemId = itemId
                )
            )
        }
    }
}

class DetailsViewModelFactory(
    private val itemId: String
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DetailsViewModel::class.java) -> {
                DetailsViewModel(itemId = itemId) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel $modelClass")
        }
    }
}
