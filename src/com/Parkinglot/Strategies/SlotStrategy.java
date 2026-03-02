package com.Parkinglot.Strategies;

public interface SlotStrategy {

    void addSlot(int slotNumber);
    void removeSlot(int slotNumber);
    int getNextSlot();
}
