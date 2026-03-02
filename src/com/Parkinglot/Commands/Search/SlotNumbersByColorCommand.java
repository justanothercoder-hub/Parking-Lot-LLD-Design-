package com.Parkinglot.Commands.Search;

import com.Parkinglot.Commands.Command;
import com.Parkinglot.Services.ParkingService;

import java.util.ArrayList;
import java.util.List;

public class SlotNumbersByColorCommand implements Command {
    private ParkingService parkingService;

    public SlotNumbersByColorCommand(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void execute(String[] inputs) {
        String color = inputs[1];
        List<Integer> slotNumbers = parkingService.getSlotNumbersByColor(color);

        // We convert the Integers to Strings so we can use String.join cleanly
        List<String> slotStrings = new ArrayList<>();
        for (Integer slot : slotNumbers) {
            slotStrings.add(String.valueOf(slot));
        }

        System.out.println(String.join(", ", slotStrings));
    }
}