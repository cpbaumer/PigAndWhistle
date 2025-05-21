package com.craigbaumer.pigandwhistle.navigation

import kotlinx.serialization.Serializable

@Serializable
data object Home

@Serializable
data class Detail(val trip: String)
