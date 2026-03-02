package com.Parkinglot;

import com.Parkinglot.Commands.*;
import com.Parkinglot.Commands.Core.CreateParkingLotCommandWithNearestSlot;
import com.Parkinglot.Commands.Core.ExitCommand;
import com.Parkinglot.Commands.Core.LeaveCommand;
import com.Parkinglot.Commands.Core.ParkCommand;
import com.Parkinglot.Commands.Search.RegistrationNumbersByColorCommand;
import com.Parkinglot.Commands.Search.SlotNumberByRegistrationCommand;
import com.Parkinglot.Commands.Search.SlotNumbersByColorCommand;
import com.Parkinglot.Commands.Search.StatusCommand;
import com.Parkinglot.Services.ParkingService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1. Create the ONE central Engine (Dependency Injection)
        ParkingService parkingService = new ParkingService();

        // 2. Build the Command Registry
        Map<String, Command> commandRegistry = new HashMap<>();

        // Core Setup
        commandRegistry.put("create_parking_lot", new CreateParkingLotCommandWithNearestSlot(parkingService));
        commandRegistry.put("exit", new ExitCommand());

        // Actions
        commandRegistry.put("park", new ParkCommand(parkingService));
        commandRegistry.put("leave", new LeaveCommand(parkingService));

        // Searches & Status
        commandRegistry.put("status", new StatusCommand(parkingService));
        commandRegistry.put("registration_numbers_for_cars_with_colour", new RegistrationNumbersByColorCommand(parkingService));
        commandRegistry.put("slot_numbers_for_cars_with_colour", new SlotNumbersByColorCommand(parkingService));
        commandRegistry.put("slot_number_for_registration_number", new SlotNumberByRegistrationCommand(parkingService));

        // 3. Start the Interactive Terminal
        Scanner scanner = new Scanner(System.in);

        // Keep running until the user types "exit" (which triggers System.exit(0))
        while (true) {
            String inputLine = scanner.nextLine().trim();

            // Ignore empty lines if the user just hits Enter
            if (inputLine.isEmpty()) {
                continue;
            }

            // Chop the sentence into words
            String[] inputs = inputLine.split(" ");
            String commandName = inputs[0]; // The first word is always the command

            // Find the button in our map
            Command command = commandRegistry.get(commandName);

            // Press the button if it exists!
            if (command != null) {
                command.execute(inputs);
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}