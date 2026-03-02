package com.Parkinglot.Commands.Search;

import com.Parkinglot.Commands.Command;
import com.Parkinglot.Models.Slot;
import com.Parkinglot.Services.ParkingService;

import java.util.List;

public class StatusCommand implements Command {
    private ParkingService parkingService;

    public StatusCommand(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void execute(String[] inputs) {
        List<Slot> occupiedSlots = parkingService.getOccupiedSlots();

        // Print the header
        System.out.println("Slot No.    Registration No    Colour");

        // Loop through and print each parked car's details
        for (Slot slot : occupiedSlots) {
            System.out.println(slot.getSlotNumber() + "           " +
                    slot.getParkedCar().getRegistrationNumber() + "      " +
                    slot.getParkedCar().getColor());
        }
    }
}
