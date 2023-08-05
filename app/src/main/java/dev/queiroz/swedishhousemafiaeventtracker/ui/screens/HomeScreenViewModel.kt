package dev.queiroz.swedishhousemafiaeventtracker.ui.screens

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.queiroz.swedishhousemafiaeventtracker.SHMApplication
import dev.queiroz.swedishhousemafiaeventtracker.data.EventRepository
import dev.queiroz.swedishhousemafiaeventtracker.model.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.Exception

sealed interface HomeUiState {
    data class Success(val events: List<Event>) : HomeUiState
    object Loading : HomeUiState
    data class Error(val message: String) : HomeUiState
}

class HomeScreenViewModel(private val eventRepository: EventRepository) : ViewModel() {

    private val _homeUiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()
    init {
        loadEvents()
    }

    private fun loadEvents(){
        viewModelScope.launch(Dispatchers.IO) {
            _homeUiState.value = HomeUiState.Loading
            _homeUiState.value  = try {
                val events = eventRepository.getEvents()
                HomeUiState.Success(events)
            }catch (exception: Exception){
                HomeUiState.Error(message = exception.toString())
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as SHMApplication)
                val repository = application.container.eventRepository
                HomeScreenViewModel(repository)
            }
        }
    }
}