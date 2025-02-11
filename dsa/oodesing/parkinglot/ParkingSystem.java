package oodesing.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

enum VehicleType {
    CAR, MOTORCYCLE, TRUCK, HANDICAPPED
}

enum ParkingSpotType {
    COMPACT, LARGE, MOTORCYCLE, HANDICAPPED
}

enum PaymentStatus {
    SUCCESS, FAILURE, PENDING
}

abstract class Vehicle {
    private final String licencePlate;
    private final VehicleType vehicleType;


    Vehicle(String licencePlate, VehicleType vehicleType) {
        this.licencePlate = licencePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

class Car extends Vehicle {
    public Car(String licencePlate) {
        super(licencePlate, VehicleType.CAR);
    }
}

class MotorCycle extends Vehicle {
    public MotorCycle(String licencePlate) {
        super(licencePlate, VehicleType.MOTORCYCLE);
    }
}


class ParkingSpot {

    private final String spotId;
    private final ParkingSpotType type;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, ParkingSpotType type) {
        this.spotId = spotId;
        this.type = type;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (!isOccupied) {
            this.parkedVehicle = vehicle;
            this.isOccupied = true;
        } else {
            throw new IllegalStateException("Spot is already occupied");
        }
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public ParkingSpotType getType() {
        return type;
    }
}

class ParkingFloor {
    private final String floorId;
    private final List<ParkingSpot> spots;

    public ParkingFloor(String floorId, int compactSpots, int largeSpots, int motorcycleSpots, int handicappedSpots) {
        this.floorId = floorId;
        this.spots = new ArrayList<>();

        for (int i = 0; i < compactSpots; i++) {
            spots.add(new ParkingSpot(floorId + "-C" + i, ParkingSpotType.COMPACT));
        }

        for (int i = 0; i < largeSpots; i++) {
            spots.add(new ParkingSpot(floorId + "-L" + i, ParkingSpotType.LARGE));
        }

        for (int i = 0; i < motorcycleSpots; i++) {
            spots.add(new ParkingSpot(floorId + "-M" + i, ParkingSpotType.MOTORCYCLE));
        }

        for (int i = 0; i < handicappedSpots; i++) {
            spots.add(new ParkingSpot(floorId + "-H" + i, ParkingSpotType.HANDICAPPED));
        }
    }

    public Optional<ParkingSpot> findAvailableSpot(ParkingSpotType type) {
        return spots.stream()
                .filter(spot -> spot.getType() == type && spot.isAvailable())
                .findFirst();
    }

    public String getFloorId() {
        return floorId;
    }
}

class ParkingLot {

}

public class ParkingSystem {
}
