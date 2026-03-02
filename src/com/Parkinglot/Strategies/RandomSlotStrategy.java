package com.Parkinglot.Strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSlotStrategy implements SlotStrategy {

    private List<Integer> availableSlots;

    public RandomSlotStrategy() {
        this.availableSlots = new ArrayList<>();
    }

    public void addSlot(int slotNumber) {
        availableSlots.add(slotNumber);
    }

    public void removeSlot(int slotNumber) {
        availableSlots.remove(Integer.valueOf(slotNumber));
    }

    public int getNextSlot() {
        if (availableSlots.isEmpty()) {
            throw new RuntimeException("Sorry, parking lot is full");
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(availableSlots.size());
        return availableSlots.get(randomIndex);
    }
}
