package interview.object_oriented_design.parking_system;

public class ParkingSpot {
	ParkingTypeSpot spotType;
	Vehicle vehicle;
	Occupancy occupancy;

	public ParkingSpot(ParkingTypeSpot spotType) {
		this.spotType = spotType;
		this.occupancy = Occupancy.FREE;
		this.vehicle = null;
	}

	public void parkVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.occupancy = Occupancy.OCCUPIED;
	}

	public void unparkVehicle() {
		this.vehicle = null;
		this.occupancy = Occupancy.FREE;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
}
