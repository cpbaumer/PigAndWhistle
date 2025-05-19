package com.craigbaumer.septa.data

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
)