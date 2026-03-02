package com.Parkinglot.Commands.Core;

import com.Parkinglot.Commands.Command;
import com.Parkinglot.Models.Car;
import com.Parkinglot.Services.ParkingService;

public class ParkCommand implements Command {
    private ParkingService parkingService;

    public ParkCommand(ParkingService parkingService){
        this.parkingService = parkingService;
    }

    @Override
    public void execute(String[] inputs){
        String regNo = inputs[1];
        String color = inputs[2];
        Car car = new Car(color , regNo);

        try {
            int allocatedSlot = parkingService.park(car);
            System.out.println("Allocated slot number: " + allocatedSlot);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
