import android.location.Location

data class MapState(
    val lastKnownLocation: Location?,
    val clusterItems: List<ZoneClusterItem>,
)
