package interview.object_oriented_design.parking_system;

import java.util.List;
import java.util.Map;

public class MainParkingLotSystem {
	//визначити тип
	//знайти вільні місця по типу
	//додлати траспорт до парковки

	public static void main(String[] args) {
		ParkingSpot spot1 = new ParkingSpot(ParkingTypeSpot.TRUCK);
		ParkingSpot spot2 = new ParkingSpot(ParkingTypeSpot.CAR);
		ParkingSpot spot3 = new ParkingSpot(ParkingTypeSpot.MOTORCYCLE);
		ParkingSpot spot4 = new ParkingSpot(ParkingTypeSpot.CAR);
		ParkingSpot spot5 = new ParkingSpot(ParkingTypeSpot.MOTORCYCLE);

		ParkingSpot spot11 = new ParkingSpot(ParkingTypeSpot.MOTORCYCLE);
		ParkingSpot spot12 = new ParkingSpot(ParkingTypeSpot.MOTORCYCLE);
		ParkingSpot spot13 = new ParkingSpot(ParkingTypeSpot.MOTORCYCLE);

		ParkingFloor floor1 = new ParkingFloor(
			Map.of("spot1", spot1, "spot2", spot2, "spot3", spot3, "spot4", spot4, "spot5", spot5),
			FloorLevel.FIRST
		);

		ParkingFloor floor2 = new ParkingFloor(
			Map.of("spot11", spot11, "spot12", spot12, "spot13", spot13),
			FloorLevel.SECOND
		);

		Car car = new Car();

		Parking parking = new Parking(List.of(floor1, floor2));
		parking.parkVehicle(car);
	}
}
