package com.Parkinglot.Commands.Core;

import com.Parkinglot.Commands.Command;
import com.Parkinglot.Models.Car;
import com.Parkinglot.Services.ParkingService;

public class LeaveCommand implements Command {
    private ParkingService parkingService;

    public LeaveCommand(ParkingService parkingService){
        this.parkingService = parkingService;
    }

    @Override
    public void execute(String[] inputs){
        int slotNumber = Integer.parseInt(inputs[1]);
        Car car = parkingService.leave(slotNumber);
        System.out.println("Slot number " + slotNumber + " is free."+"Car of color:"+car.getColor()+" Reg.No: " +car.getRegistrationNumber()+ " has left"); //
    }
}
