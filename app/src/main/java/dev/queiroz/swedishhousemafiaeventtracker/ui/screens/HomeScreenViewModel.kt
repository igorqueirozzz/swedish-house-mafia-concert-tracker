package dev.queiroz.swedishhousemafiaeventtracker.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.queiroz.swedishhousemafiaeventtracker.data.repository.EventRepository
import dev.queiroz.swedishhousemafiaeventtracker.model.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface HomeUiState {
    data class Success(val events: List<Event>) : HomeUiState
    object Loading : HomeUiState
    data class Error(val message: String) : HomeUiState
}

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val eventRepository: EventRepository) :
    ViewModel() {

    private val _homeUiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    init {
        loadEvents()
    }

    private fun loadEvents() {
        viewModelScope.launch(Dispatchers.IO) {
            _homeUiState.value = HomeUiState.Loading
            _homeUiState.value = try {
                val events = eventRepository.getEvents()
                HomeUiState.Success(events)
            } catch (exception: Exception) {
                HomeUiState.Error(message = exception.toString())
            }
        }
    }

}