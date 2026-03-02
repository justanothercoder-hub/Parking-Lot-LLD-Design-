package com.Parkinglot.Services;

import java.util.ArrayList;
import java.util.List;

import com.Parkinglot.Models.Car;
import com.Parkinglot.Models.Slot;
import com.Parkinglot.Repositories.ParkingLotRepository;
import com.Parkinglot.Strategies.SlotStrategy;

public class ParkingService {
    private ParkingLotRepository repository;
    private SlotStrategy strategy;

    public ParkingService(){
        this.repository=null;
        this.strategy=null;
    }

    public void createParkingLot(int capacity, SlotStrategy strategy){
        this.repository=new ParkingLotRepository(capacity);
        this.strategy=strategy;

        for (int i=1; i<=capacity; i++){
            this.strategy.addSlot(i);
        }
    }

    public int park(Car car){
        if (this.repository == null) {
            throw new RuntimeException("Parking lot is not created yet.");
        }

        int parkSlotNumber = strategy.getNextSlot();
        Slot slot = repository.getSlot(parkSlotNumber);
        strategy.removeSlot(parkSlotNumber);

        slot.setParkedcar(car);
        return parkSlotNumber;
    }

    public Car leave(int slotNumber){
        if (this.repository == null) {
            throw new RuntimeException("Parking lot is not created yet.");
        }
        Slot slot = repository.getSlot(slotNumber);
         
        Car departingCar = slot.getParkedCar();
        slot.setParkedcar(null);
        strategy.addSlot(slotNumber);

        return departingCar;
    }

    public List<Slot> getOccupiedSlots(){
        if(this.repository == null) {
            return new ArrayList<>();
        }

        List<Slot> occupiedSlots = new ArrayList<>();

        for(Slot slot : repository.getAllSlots()){
            if(!slot.isFree()){
                occupiedSlots.add(slot);
            }
        }
        return occupiedSlots;
    }

    public List<String> getRegistrationNumbersByColor(String color){
        List<String> registrationNumbers = new ArrayList<>();
        for(Slot slot : getOccupiedSlots()){
            Car car = slot.getParkedCar();
            if(car != null && car.getColor().equals(color)){
                registrationNumbers.add(car.getRegistrationNumber());
            }
        }
        return registrationNumbers;
    }

    public List<Integer> getSlotNumbersByColor(String color){
        List<Integer> slotNumbers = new ArrayList<>();
        for(Slot slot : getOccupiedSlots()){
            Car car = slot.getParkedCar();
            if(car != null && car.getColor().equals(color)){
                slotNumbers.add(slot.getSlotNumber());
            }
        }
        return slotNumbers;
    }

    public int getSlotNumberByRegistrationNumber(String registrationNumber){
    
        for(Slot slot : repository.getAllSlots()){
            Car car = slot.getParkedCar();
            if(car != null && car.getRegistrationNumber().equals(registrationNumber)){
                return slot.getSlotNumber();
            }
        }
        
            throw new RuntimeException("Not found");
        
    }
}
