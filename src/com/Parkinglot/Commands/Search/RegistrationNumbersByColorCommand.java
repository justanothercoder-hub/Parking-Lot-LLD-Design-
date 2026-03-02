package com.Parkinglot.Commands.Search;

import com.Parkinglot.Commands.Command;
import com.Parkinglot.Services.ParkingService;
import java.util.List;

public class RegistrationNumbersByColorCommand implements Command {
    private ParkingService parkingService;

    public RegistrationNumbersByColorCommand(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void execute(String[] inputs) {
        String color = inputs[1];
        List<String> regNumbers = parkingService.getRegistrationNumbersByColor(color);

        // String.join is a fantastic shortcut to print a list with commas!
        System.out.println(String.join(", ", regNumbers));
    }
}
