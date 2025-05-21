package com.craigbaumer.septa.data

import com.craigbaumer.septa.data.models.TrainLocations
import javax.inject.Inject

class TrainRepository @Inject constructor(val client: SeptaClient) {

    suspend fun getTrainLocations(): TrainLocations {
        return client.instance.getTrainLocations()
    }
}
