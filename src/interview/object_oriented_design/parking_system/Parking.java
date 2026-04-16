package interview.object_oriented_design.parking_system;

import java.util.List;

public class Parking {
	List<ParkingFloor> floors;

	public Parking(List<ParkingFloor> floors) {
		this.floors = floors;
	}

	void unparkVehicle(String name){
		floors
			.forEach(floor -> {
				ParkingSpot parkingSpot = floor.spots.get(name);
				parkingSpot.unparkVehicle();
			});
	}

	void parkVehicle(Vehicle vehicle){
		floors.forEach(floor -> {
				ParkingSpot spot = floor.getFreeSpotsByType(vehicle.type).stream().findFirst().orElseThrow();
				floor.spots.put(vehicle.name, spot);
			});
	}
}
