package com.craigbaumer.pigandwhistle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.craigbaumer.septa.data.TrainRepository
import com.craigbaumer.septa.data.models.TrainLocation
import com.craigbaumer.septa.data.models.TrainLocations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val trainRepository: TrainRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(TrainState())
    val state: StateFlow<TrainState> = _state.asStateFlow()

    fun onEvent(event: TrainEvent) {
        when (event) {
            is TrainEvent.Refresh -> getTrainLocations()
            is TrainEvent.Start -> getTrainLocations()
        }
    }

    fun getTripLocation(trip: String) : TrainLocation? {
        return _state.value.trainLocations.trainLocations.find { it.trip == trip }
    }

    private fun getTrainLocations() {
        _state.value = _state.value.copy(isRefreshing = true)

        viewModelScope.launch {
            val locations = trainRepository.getTrainLocations()
            _state.value = TrainState(
                trainLocations = locations,
                isRefreshing = false,
            )
        }
    }
}

data class TrainState(
    val trainLocations: TrainLocations = TrainLocations(trainLocations = emptyList()),
    val isRefreshing: Boolean = false,
)

sealed interface TrainEvent {
    data object Refresh : TrainEvent
    data object Start : TrainEvent
}
