package com.craigbaumer.septa.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrainLocations (
    @SerialName("bus")
    val trainLocations: List<TrainLocation>,
)
