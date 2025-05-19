package com.craigbaumer.septa.data

import retrofit2.http.GET

interface TrainService {

    @GET("TransitView/index.php?route=M1")
    suspend fun getTrainLocations(): TrainLocations
}
