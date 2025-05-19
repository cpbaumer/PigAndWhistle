package com.craigbaumer.pigandwhistle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.craigbaumer.septa.data.SeptaClient
import com.craigbaumer.septa.data.TrainLocations
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val septaClient = SeptaClient.instance

    private val _state = MutableStateFlow(TrainLocations(trainLocations = emptyList()))
    val state: StateFlow<TrainLocations> = _state.asStateFlow()

    fun getTrainLocations() {
        viewModelScope.launch {
            val locations = septaClient.getTrainLocations()
            _state.value = locations
        }
    }
}
