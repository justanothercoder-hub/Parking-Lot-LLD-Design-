package com.Parkinglot.Commands.Core;

import com.Parkinglot.Commands.Command;
import com.Parkinglot.Services.ParkingService;
import com.Parkinglot.Strategies.NearestSlotStrategy;
import com.Parkinglot.Strategies.RandomSlotStrategy;

public class CreateParkingLotCommandWithNearestSlot implements Command {
      private ParkingService parkingService;

      public CreateParkingLotCommandWithNearestSlot(ParkingService parkingService){
          this.parkingService=parkingService;
      }

      public void execute(String[] inputs){
        int capacity = Integer.parseInt(inputs[1]);
        this.parkingService.createParkingLot(capacity, new NearestSlotStrategy());
        System.out.println("Created a parking lot with " + capacity + " slots. The nearest slot strategy will be used for parking.");
      }
    }



