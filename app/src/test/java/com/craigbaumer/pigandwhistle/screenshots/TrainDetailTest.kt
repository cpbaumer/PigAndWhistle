package com.craigbaumer.pigandwhistle.screenshots

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.craigbaumer.pigandwhistle.ui.TrainDetail
import com.craigbaumer.septa.data.models.TrainLocation
import org.junit.Rule
import org.junit.Test

class TrainDetailTest {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.Companion.PIXEL_5,
        theme = "android:Theme.Material.Light.NoActionBar"
        // ...see docs for more options
    )

    @Test
    fun trainDetail() {
        paparazzi.snapshot {
            TrainDetail(trainLocation = TrainLocation.Companion.SAMPLE_LOCATION)
        }
    }
}
