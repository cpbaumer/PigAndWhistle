package com.craigbaumer.septa.data.models

data class TrainStop(
    val lng : Double,
    val lat : Double,
    val stopIds: Set<String>,
    val stopName: String,
) {
    companion object {
        val TRAIN_STOPS = setOf(
            TrainStop(
                lng = -75.345114,
                lat = 40.113459,
                stopIds = setOf("30520", "32185"),
                stopName = "Norristown",
            ),
            TrainStop(
                lng = -75.348094,
                lat = 40.104946,
                stopIds = setOf("1892", "32186"),
                stopName = "Bridgeport",
            ),
            TrainStop(
                lng = -75.352018,
                lat = 40.098736,
                stopIds = setOf("1935", "32187"),
                stopName = "DeKalb St",
            ),
            TrainStop(
                lng = -75.349079,
                lat = 40.081535,
                stopIds = setOf("1934", "32188"),
                stopName = "Hughes Park",
            ),
            TrainStop(
                lng = -75.342278,
                lat = 40.070847,
                stopIds = setOf("1895", "32189"),
                stopName = "Gulph Mills",
            ),
            TrainStop(
                lng = -75.339408,
                lat = 40.058206,
                stopIds = setOf("1932", "32190"),
                stopName = "Matsonford",
            ),
            TrainStop(
                lng = -75.353558,
                lat = 40.042052,
                stopIds = setOf("1930", "32192"),
                stopName = "Radnor",
            ),
            TrainStop(
                lng = -75.344025,
                lat = 40.034085,
                stopIds = setOf("1929", "32193"),
                stopName = "Villanova",
            ),
            TrainStop(
                lng = -75.340729,
                lat = 40.032699,
                stopIds = setOf("1900", "32194"),
                stopName = "Stadium",
            ),
            TrainStop(
                lng = -75.336361,
                lat = 40.027974,
                stopIds = setOf("1927", "32195"),
                stopName = "Garrett Hill",
            ),
            TrainStop(
                lng = -75.330234,
                lat = 40.021401,
                stopIds = setOf("1902", "32196"),
                stopName = "Roberts Rd",
            ),
            TrainStop(
                lng = -75.323383,
                lat = 40.018084,
                stopIds = setOf("1925", "32197"),
                stopName = "Bryn Mawr",
            ),
            TrainStop(
                lng = -75.315099,
                lat = 40.00983,
                stopIds = setOf("1924", "32198"),
                stopName = "Haverford",
            ),
            TrainStop(
                lng = -75.309419,
                lat = 39.999936,
                stopIds = setOf("1923", "32199"),
                stopName = "Ardmore Ave",
            ),
            TrainStop(
                lng = -75.303659,
                lat = 39.996289,
                stopIds = setOf("30519", "32200"),
                stopName = "Ardmore Junction",
            ),
            TrainStop(
                lng = -75.298182,
                lat = 39.9934,
                stopIds = setOf("1921", "32201"),
                stopName = "Wynnewood",
            ),
            TrainStop(
                lng = -75.291448,
                lat = 39.986548,
                stopIds = setOf("1908", "32202"),
                stopName = "Beechwood-Brookline",
            ),
            TrainStop(
                lng = -75.283933,
                lat = 39.980997,
                stopIds = setOf("1919", "32203"),
                stopName = "Penfield",
            ),
            TrainStop(
                lng = -75.281536,
                lat = 39.974818,
                stopIds = setOf("1918", "32204"),
                stopName = "Township Line",
            ),
            TrainStop(
                lng = -75.27478,
                lat = 39.969026,
                stopIds = setOf("1917", "32207"),
                stopName = "Parkview",
            ),
            TrainStop(
                lng = -75.259156,
                lat = 39.962759,
                stopIds = setOf("31790", "32206"),
                stopName = "69th St",
            ),
        )
    }
}
