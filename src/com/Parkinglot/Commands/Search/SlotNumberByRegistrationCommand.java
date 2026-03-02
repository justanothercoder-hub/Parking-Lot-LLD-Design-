package com.Parkinglot.Commands.Search;

import com.Parkinglot.Commands.Command;
import com.Parkinglot.Services.ParkingService;

public class SlotNumberByRegistrationCommand implements Command {
    private ParkingService parkingService;

    public SlotNumberByRegistrationCommand(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void execute(String[] inputs) {
        String registrationNumber = inputs[1];

        try {
            int slotNumber = parkingService.getSlotNumberByRegistrationNumber(registrationNumber);
            System.out.println(slotNumber);
        } catch (RuntimeException e) {
            // This will perfectly catch and print your "Not found" message!
            System.out.println(e.getMessage());
        }
    }
}