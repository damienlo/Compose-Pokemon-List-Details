package jet.pack.compose.masterdetails.ui.screens.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import jet.pack.compose.masterdetails.ui.model.ListPreviewUiItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

sealed class ListState {
    object Loading : ListState()
    data class Success(val uiItems: List<ListPreviewUiItem>) : ListState()
    data class Error(val cause: Exception) : ListState()
}

class ListViewModel : ViewModel() {

    private val _state = MutableLiveData<ListState>()
    val state: LiveData<ListState> = _state

    init {
        _state.value = ListState.Loading
        viewModelScope.launch {
            delay(750L)
            _state.value = ListState.Success(
                listOf(ListPreviewUiItem(itemId = "#010101"))
            )
        }
    }
}

class ListViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ListViewModel::class.java) -> {
                ListViewModel() as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel $modelClass")
        }
    }
}
