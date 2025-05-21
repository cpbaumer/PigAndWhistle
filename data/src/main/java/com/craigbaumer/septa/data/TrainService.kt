package com.craigbaumer.septa.data

import com.craigbaumer.septa.data.models.TrainLocations
import retrofit2.http.GET

interface TrainService {

    @GET("TransitView/index.php?route=M1")
    suspend fun getTrainLocations(): TrainLocations
}
