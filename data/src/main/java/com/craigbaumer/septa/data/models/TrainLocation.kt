package com.craigbaumer.septa.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrainLocation(
    val lat: String, // Or Double if you prefer to parse it directly
    val lng: String, // Or Double if you prefer to parse it directly
    val label: String,
    @SerialName("route_id")
    val routeId: String,
    val trip: String,
    @SerialName("VehicleID")
    val vehicleID: String,
    @SerialName("BlockID")
    val blockID: String,
    @SerialName("Direction")
    val direction: String = "", // Seems to be "N/A", consider an Enum or String
    val destination: String,
    // val heading: String? = null, // Assuming heading can be null
    val late: Int = 0,
    @SerialName("next_stop_id")
    val nextStopId: String? = null,
    @SerialName("next_stop_name")
    val nextStopName: String? = null,
    @SerialName("next_stop_sequence")
    val nextStopSequence: Int? = null,
    @SerialName("estimated_seat_availability")
    val estimatedSeatAvailability: String = "", // Consider an Enum if values are fixed
    @SerialName("Offset")
    val offset: Int = 0,
    @SerialName("Offset_sec")
    val offsetSec: String = "", // Or Int if you prefer to parse it directly
    val timestamp: Long, // Assuming it's a Unix timestamp
) {
    companion object {
        val SAMPLE_LOCATION = TrainLocation(
            lat = "40.050251",
            lng = "-75.347250",
            label = "136",
            routeId = "M1",
            trip = "71328",
            vehicleID = "136",
            blockID = "4019",
            direction = "N/A",
            destination = "69th Street Transit Center",
            late = 2,
            nextStopId = "32192",
            nextStopName = "Radnor - NHSL",
            nextStopSequence = 7,
            estimatedSeatAvailability = "NOT_AVAILABLE",
            offset = 2,
            offsetSec = "102",
            timestamp = 1747685589,
        )
    }
}

fun TrainLocation.getDirection(): Direction {
    return when {
        destination.contains("Norristown") -> Direction.Norristown
        destination.contains("69") -> Direction.SixtyNinthSt
        else -> Direction.Unknown
    }
}
