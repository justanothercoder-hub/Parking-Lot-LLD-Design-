package com.Parkinglot.Commands.Core;

import com.Parkinglot.Commands.Command;
import com.Parkinglot.Services.ParkingService;
import com.Parkinglot.Strategies.RandomSlotStrategy;

public class CreateParkingLotCommandWithRandomSlot implements Command {
    private ParkingService parkingService;

    public CreateParkingLotCommandWithRandomSlot(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void execute(String[] inputs) {
        // inputs looks like: ["create_parking_lot", "6"]
        int capacity = Integer.parseInt(inputs[1]);

        // We inject our PriorityQueue strategy right here!
        parkingService.createParkingLot(capacity, new RandomSlotStrategy());

        // Output format matching the requirements exactly
        System.out.println("Created a parking lot with " + capacity + " slots. The random slot strategy will be used for parking"); //
    }
}