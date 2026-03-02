package com.Parkinglot.Strategies;

import java.util.PriorityQueue;

public class NearestSlotStrategy implements SlotStrategy{

    private PriorityQueue<Integer> availableSlots;

    public NearestSlotStrategy(){
        this.availableSlots=new PriorityQueue<>();
    }

    public void addSlot(int slotNumber){
        availableSlots.add(slotNumber);
    }

    public void removeSlot(int slotNumber) {
        availableSlots.remove(slotNumber);
    }

    public int getNextSlot() {
        if (availableSlots.isEmpty()) {
            throw new RuntimeException("Sorry, parking lot is full"); 
        }
        return availableSlots.peek(); 
    }
}
