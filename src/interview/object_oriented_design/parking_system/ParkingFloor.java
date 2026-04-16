package interview.object_oriented_design.parking_system;

import java.util.List;
import java.util.Map;

public class ParkingFloor {
	Map<String, ParkingSpot> spots;
	FloorLevel level;

	public ParkingFloor(
		Map<String, ParkingSpot> spots,
		FloorLevel level
	) {
		this.spots = spots;
		this.level = level;
	}

	public List<ParkingSpot> getFreeSpotsByType(String type) {
		return spots.values().stream()
			.filter(spot -> spot.occupancy == Occupancy.FREE && spot.spotType == ParkingTypeSpot.valueOf(type))
			.toList();
	}
}
