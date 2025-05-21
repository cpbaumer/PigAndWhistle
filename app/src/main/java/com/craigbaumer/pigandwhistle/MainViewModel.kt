package com.craigbaumer.pigandwhistle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.craigbaumer.septa.data.SeptaClient
import com.craigbaumer.septa.data.TrainLocation
import com.craigbaumer.septa.data.TrainLocations
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel : ViewModel() {

    private val septaClient = SeptaClient.instance

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
        Timber.i("getTrainLocations")

        _state.value = _state.value.copy(isRefreshing = true)

        viewModelScope.launch {
            val locations = septaClient.getTrainLocations()
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
